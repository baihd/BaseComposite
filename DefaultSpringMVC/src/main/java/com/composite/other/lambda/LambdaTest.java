package com.composite.other.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {
        testThread();
        testActionListener();
        testList();
        testPredicate();
        testPredicate2();
        testMapReduce();
        testMapReduce2();
        testCollect();
        testCollect2();
        testCollect3();
        testIntSummaryStatistics();
    }

    private static void testThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8");
            }
        }).start();
        new Thread(() -> System.out.println("In Java8")).start();
    }

    private static void testActionListener() {
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Before Java8");
            }
        });
        show.addActionListener(e -> System.out.println("In Java8"));
    }

    private static void testList() {
        List<String> features = Arrays.asList("Lambdas", "Default Method");
        for (String feature : features) {
            System.out.println(feature);
        }
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);
    }

    private static void testPredicate() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++");
        filter(languages, str -> ((String) str).startsWith("J"));
    }

    private static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    private static void testPredicate2() {
        Predicate<String> startsWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        List names = Arrays.asList("Java", "Scala", "C++");
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach(n -> System.out.println(n));
    }

    private static void testMapReduce() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + 0.12 * cost;
            System.out.println(price);
        }
        costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
    }

    private static void testMapReduce2() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + 0.12 * cost;
            total = total + price;
        }
        System.out.println(total);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println(bill);
    }

    private static void testCollect() {
        List<String> strList = Arrays.asList("abc", "", "bcd", "defg", "jk");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s,filter list : %s %n", strList, filtered);
    }

    private static void testCollect2() {
        List<String> g7 = Arrays.asList("USA", "Japan", "France");
        String g7s = g7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(g7s);
    }

    private static void testCollect3() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List: %s,Square Without duplicates: %s %n", numbers, distinct);
    }

    private static void testIntSummaryStatistics() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
    }


}
