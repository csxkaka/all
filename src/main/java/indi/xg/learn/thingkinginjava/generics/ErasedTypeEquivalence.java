package indi.xg.learn.thingkinginjava.generics;

import java.util.ArrayList;

/**
 * 泛型擦除
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        /*
         * 泛型擦除的意思是，不管你的泛型是什么类型的，比如这里的String, String
         * 在编译时都会将他们忽略，
         * 在这个例子中可以看到，即使泛型是String，Integer，
         * 但返回的都是ArrayList的Class类对象，每个类只有一个类对象
         */
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);   // true
    }
}
