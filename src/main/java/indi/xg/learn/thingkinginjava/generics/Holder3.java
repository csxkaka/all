package indi.xg.learn.thingkinginjava.generics;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 泛型，泛型最主要的作用就是创造一个容器类，这个容器可以存放对象，比如集合，数组，都是可称得上是使用了泛型的
 * @param <T>   类型参数，可以为别的字符，但要保证与类中的代码一致
 */
public class Holder3<T> {
    // Holder3<T>表示这是一个容器，这个容器里面可以存入一种类型T，之后我们只能从这个容器中到类型T的对象
    private T a;
    public Holder3(T a) {
        this.a = a;
    }
    // 这里的T都必须和类声明时的类型参数一样
    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        // 在创建Holder3对象时，传入一个具体的类型，后一个<>内可以不写，不会发出警告，编译器会自动判断
        Holder3<AtomicInteger> h1 = new Holder3<>(new AtomicInteger());
        // 取出的对象就是AtomicInteger，不可能是别的
        AtomicInteger atomicInteger = h1.getA();

        Holder3<AtomicBoolean> h2 = new Holder3<>(new AtomicBoolean());
        // 同样的，只能存入一个类型AtomicBoolean的对象
        h2.setA(new AtomicBoolean());
        // 取出来的也是类型AtomicBoolean的对象
        AtomicBoolean atomicBoolean = h2.getA();
    }
}
