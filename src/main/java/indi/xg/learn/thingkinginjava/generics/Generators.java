package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.generics.coffee.Coffee;
import indi.xg.learn.thingkinginjava.generics.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 生成器使用泛型方法，填充一个集合
 */
public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            // 调用对应的next，就会创建对象
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (int i : fnumbers) {
            System.out.print(i + ", ");
        }
    }
 }
