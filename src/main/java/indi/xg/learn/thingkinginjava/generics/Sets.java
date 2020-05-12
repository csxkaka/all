package indi.xg.learn.thingkinginjava.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * 利用Set实现数学集合公式
 */
public class Sets {
    /**
     * 返回一个新的Set，表示两个Set的并集
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 返回一个新的Set，表示两个集合的交集
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 返回一个新的Set，表示从一个集合中移除包含另一个集合的所有元素
     * @param superSet
     * @param subSet
     * @param <T>
     * @return
     */
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);
        return result;
    }

    /**
     * 返回一个新的Set，表示除去两个集合交集后的所有元素
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
