package com.composite.other.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    /**
     * filter过滤
     */
    static void testFilter() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //截取所有能被2整除的数据
        List<Integer> collect = integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * distinct去重
     */
    static void testDistinct() {
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> collect = integers.stream().distinct().collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * sorted排序
     */
    static void testSorted() {
        List<Integer> integers = Arrays.asList(5, 8, 2, 6, 41, 11);
        List<Integer> sorted = integers.stream().sorted().collect(Collectors.toList());
        System.out.println("顺序 = " + sorted);
        List<Integer> reverseOrder = integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("逆序 = " + reverseOrder);
    }

    /**
     * limit截取
     */
    static void testLimit() {
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        //截取流中的前三个元素 collect = [1,2,1]
        List<Integer> collect = integers.stream().limit(3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * skip舍弃
     */
    static void testSkip() {
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        //丢掉流中的前三个元素　collect = [3,3,2,4]
        List<Integer> collect = integers.stream().skip(3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * map归纳
     */
    static void testMap() {
        List<Dish> dishList = Dish.getDishList();
        List<String> collect = dishList.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }


    /**
     * flatMap扁平化
     */
    static void testFlatMap() {
        String[] words = {"Hello", "World"};
        //数组转换流
        List<String> collect = Stream.of(words)
                //去掉""并获取到两个String[]
                .map(w -> w.split(""))
                //方法调用将两个String[]
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * peek
     */
    static void testPeek() {
        List<Integer> integers = Arrays.asList(2, 3, 4, 5);
        List<Integer> result = integers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());
    }

    /**
     * collect收集
     */
    static void testCollect() {
        List<Dish> dishList = Dish.getDishList();
        List<Dish> collect1 = dishList.stream().limit(2).collect(Collectors.toList());
        Set<Dish> collect2 = dishList.stream().limit(2).collect(Collectors.toSet());
    }

    /**
     * anyMatch
     */
    static void testAnyMatch() {
        List<Dish> dishList = Dish.getDishList();
        boolean b = dishList.stream().anyMatch(Dish::isVegetarian);
        System.out.println(b);
    }

    /**
     * allMatch
     */
    static void testAllMatch() {
        List<Dish> dishList = Dish.getDishList();
        boolean b = dishList.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(b);
    }

    /**
     * noneMatch
     */
    static void testNoneMatch() {
        List<Dish> dishList = Dish.getDishList();
        boolean b = dishList.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(b);
    }

    /**
     * findAny
     */
    static void testFindAny() {
        List<Dish> dishList = Dish.getDishList();
        Optional<Dish> any = dishList.stream().filter(Dish::isVegetarian).findAny();
        System.out.println("any = " + any);
    }

    /**
     * findFirst
     */
    static void testFindFirst() {
        List<Dish> dishList = Dish.getDishList();
        Optional<Dish> any = dishList.stream().filter(Dish::isVegetarian).findFirst();
        System.out.println("any = " + any);
    }

    /**
     * reduce
     */
    static void testReduce() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 6, 8);
        Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        int sum = integers.stream().reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
    }

    /**
     * 最大值和最小值
     */
    static void testMaxAndMin() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 6, 8);
        Optional<Integer> min = integers.stream().reduce(Integer::min);
        System.out.println("min = " + min);
        Optional<Integer> max = integers.stream().reduce(Integer::max);
        System.out.println("max = " + max);
    }

    /**
     * 查找流中的最大值和最小值minBy maxBy
     */
    static void testMaxByAndMinBy() {
        List<Dish> dishList = Dish.getDishList();
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect1 = dishList.stream().collect(Collectors.maxBy(dishComparator));
        System.out.println("collect1 = " + collect1);
        Optional<Dish> collect2 = dishList.stream().collect(Collectors.minBy(dishComparator));
        System.out.println("collect2 = " + collect2);
    }

    /**
     * 汇总summingInt
     */
    static void testSummingInt() {
        List<Dish> dishList = Dish.getDishList();
        int collect = dishList.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("collect = " + collect);
    }

    /**
     * 平均数averagingInt
     */
    static void testAveragingInt() {
        List<Dish> dishList = Dish.getDishList();
        Double collect = dishList.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("collect = " + collect);
    }

    /**
     * 连接字符串
     */
    static void testJoining() {
        List<Dish> dishList = Dish.getDishList();
        String collect = dishList.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("collect = " + collect);
    }

    /**
     * 得到流中的总数
     */
    static void testCounting() {
        List<Dish> dishList = Dish.getDishList();
        long counting = dishList.stream().collect(Collectors.counting());
    }

    /**
     * 分组
     */
    static void testGroupingBy() {
        List<Dish> dishList = Dish.getDishList();
        Map<String, List<Dish>> collect = dishList.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return "DIET";
            } else if (dish.getCalories() <= 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        }));
    }


}
