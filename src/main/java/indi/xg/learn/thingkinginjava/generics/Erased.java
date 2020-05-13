package indi.xg.learn.thingkinginjava.generics;

public class Erased<T> {
    private static final int SIZE = 100;
    public static void f(Object arg) {
        // 这些都无法正确编译，因为类型信息被擦除了，编译的时候只知道这是一个Erased类，而根本不知道有T
//        if (arg instanceof T) {}
//        T val = new T();
//        T[] array = new T[SIZE];
//        T[] array2 = (T[]) new Objects[SIZE];
    }
}
