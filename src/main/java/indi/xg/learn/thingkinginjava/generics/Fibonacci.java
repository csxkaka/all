package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.util.Generator;

/**
 * 使用生成器，生成斐波那契数列
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        // fib返回的是int类型，泛型虽然不能是基本类型，但会自动装箱
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(gen.next());
        }
    }
}
