package com.composite.other.generic;

import com.composite.other.generic.genericClass.MorePoint;
import com.composite.other.generic.genericClass.Point;
import com.composite.other.generic.genericFunction.StaticFans;
import com.composite.other.generic.genericInterface.Info;
import com.composite.other.generic.genericInterface.InfoImpl;
import com.composite.other.generic.genericInterface.InfoImplInterface;
import com.composite.other.generic.genericInterface.InfoImplInterfaceMore;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        testGenericClass();
//        testMoreGenericClass();
//        testGenericInterface();
//        testGenericInterfaceInterface();
//        testGenericInterfaceInterfaceMore();
//        testGenericFunction();
//        testGenericFunction2();


        int a = 3%9;
        int b = 2&(8-1);
        System.out.println(a);
        System.out.println(b);
    }

    private static void testGenericClass() {
        Point<Integer> p1 = new Point<>();
        p1.setX(100);
        System.out.println(p1.getX());

        Point<String> p2 = new Point<>();
        p2.setX("hello");
        System.out.println(p2.getX());
    }

    private static void testMoreGenericClass() {
        MorePoint<Integer, String> morePoint = new MorePoint<>();
        morePoint.setName("hello world");
        System.out.println(morePoint.getName());
    }

    private static void testGenericInterface() {
        InfoImpl info = new InfoImpl("info");
        System.out.println(info.getVar());
    }

    private static void testGenericInterfaceInterface() {
        Info<String> info = new InfoImplInterface<>("info2");
        System.out.println(info.getVar());
    }

    private static void testGenericInterfaceInterfaceMore() {
        Info<String> info = new InfoImplInterfaceMore<Integer, Double, String>("info3");
        System.out.println(info.getVar());
    }

    private static void testGenericFunction() {
        StaticFans.staticMethod("staticMethod1");
        StaticFans staticFans = new StaticFans();
        staticFans.otherMethod(123);
    }


    public static void testGenericFunction2() {
        List<Integer> test1 = Arrays.asList(1, 2, 3);
        List<String> test2 = Arrays.asList("one", "two", "three");
        List<Object> test3 = Arrays.asList(1, "two", 1.23);
        StaticFans.printList1(test3);
        StaticFans.printList2(test1);
        StaticFans.printList2(test2);
        StaticFans.printList2(test3);
        StaticFans.printList3(test1);
        StaticFans.printList3(test2);
        StaticFans.printList3(test3);
    }


    /**
     * 字母
     *  E — Element，常用在java Collection里，如：List<E>,Iterator<E>,Set<E>
     *      K,V — Key，Value，代表Map的键值对
     *      N — Number，数字
     *      T — Type，类型，如String，Integer等等
     *
     *  Object和T：Object并没有泛指哪个类，而T可以泛指Object
     *
     *  T：表示泛型，new的时候要加入泛型，更方便通用
     *  ?：表示不确定的类型，一般用在通配，HashMap的括号里面不能是T,E等不确定的东西,但可以是?
     *  ?和T：?和T都表示不确定的类型，但如果是T，函数里面可以对T进行操作，比方 T car = getCar()，而不能用? car = getCar()
     */



}
