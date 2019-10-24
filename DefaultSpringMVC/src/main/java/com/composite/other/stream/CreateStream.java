package com.composite.other.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
        createStream1();
        createStream2();
        createStream3();
        createStream4();
        createStream5();
    }

    //通过数组，Stream.of()
    static void createStream1() {
        String[] str = {"a", "b", "c"};
        Stream<String> stream = Stream.of(str);
        stream.forEach(x -> System.out.print(x));
        System.out.println();
    }

    //通过集合
    static void createStream2() {
        List<String> strings = Arrays.asList("a", "b", "c");
        Stream<String> stream = strings.stream();
        stream.forEach(x -> System.out.print(x));
        System.out.println();
    }

    //通过Stream.generate
    static void createStream3() {
        //这是一个无限流,通过这种方法创建在操作的时候最好加上limit进行限制
        Stream<Integer> generate = Stream.generate(() -> 2);
        generate.limit(10).forEach(x -> System.out.print(x));
        System.out.println();
    }

    //通过Stream.iterate
    static void createStream4() {
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(x -> System.out.print(x));
        System.out.println();
    }

    //其他API
    static void createStream5() {
        String str = "abc";
        IntStream chars = str.chars();
        chars.forEach(x -> System.out.print(x));
        System.out.println();
    }


}
