package indi.xg.learn.thingkinginjava.typeinfo;

import java.io.Serializable;

/**
 * Class<?>方式获取的是所有类型的Class引用，如果想要获取某种限定类型以及它的子类型，可以通过
 * extends 类实现
 */
public class BoundedClassReference {
    public static void main(String[] args) {
        // 这里的意思是获取Number类对象或其任意子类对象的Class引用
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Float.class;
        // 自己本身也是可以的，但如果想获取Number的父类型是不行的
        bounded = Number.class;

        // 这里的意思是获取Integer类型或它的任意父类型对象的Class引用
        Class<? super Integer> d = Number.class;
        // int自动转为Integer
        d = int.class;
        // Integer的父类或父接口都是可以
        d = Object.class;
        d = Comparable.class;
        // Serializable是Number实现的接口，同样是可以的
        d = Serializable.class;
        // 获取Integer的子类型是不可以
    }
}

