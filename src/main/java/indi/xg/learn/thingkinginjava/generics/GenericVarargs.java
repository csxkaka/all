package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.generics.util.New;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型可变参数
 */
public class GenericVarargs {

    /**
     * 此方法和java.util.Arrays.asList()方法的功能是相同的
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> makeList(T...args) {
        List<T> result = new ArrayList<>();
        for (T t : args) {
            result.add(t);
        }
        return result;
    }

    /**
     * 从这个例子中看到，可变参数并非只是数组，它可以仅仅是一个参数，也可以是多个
     * 可以是数组，可以是集合，还可以是多个参数列表
     * @param args
     */
    public static void main(String[] args) {
        // 一个参数
        List<String> ls = makeList("A");
        System.out.println(ls);

        // 以逗号隔开的多个参数
        ls = makeList("A", "C", "B");
        System.out.println(ls);

        // 数组
        List<String> stringList = makeList("ABCDEFG".split(""));
        System.out.println(stringList);

        // 集合
        List<List<String>> listList = makeList(New.list());
        System.out.println(listList);
    }
}
