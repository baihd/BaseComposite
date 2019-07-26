package com.composite.other.generic.genericFunction;

import java.util.List;

public class StaticFans {
    public static <T> void staticMethod(T a) {
        System.out.println("staticMethod:" + a.toString());
    }

    public <T> void otherMethod(T a) {
        System.out.println("otherMethod:" + a.toString());
    }

    public static void printList1(List<Object> list) {
        for (Object obj : list) {
            System.out.println(obj + " ");
        }
    }

    public static <T> void printList2(List<T> list) {
        for (T t : list) {
            System.out.println(t + " ");
        }
    }

    public static void printList3(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }

}
