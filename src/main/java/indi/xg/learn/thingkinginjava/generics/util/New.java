package indi.xg.learn.thingkinginjava.generics.util;

import java.util.*;

/**
 * 一个工具类，用来创建不同的容器
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }
    public static <E> List<E> lList() {
        // 后一个<>内的都可以不写
        return new LinkedList<>();
    }
    public static <T> Set<T> set() {
        return new HashSet<>();
    }
    public static <T> Queue<T> queue() {
        return new LinkedList();
    }
}
