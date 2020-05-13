package indi.xg.learn.thingkinginjava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();
    static void f1() {
        writeExact(apples, new Apple());

        writeExact(fruit, new Apple());
        writeExact(fruit, new Fruit());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        // 添加的类型可以是T和T的子类型
        list.add(item);
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
