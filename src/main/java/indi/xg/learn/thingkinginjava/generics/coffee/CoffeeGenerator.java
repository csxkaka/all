package indi.xg.learn.thingkinginjava.generics.coffee;

import indi.xg.learn.thingkinginjava.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * 泛型接口，生成器，随机生成一个具体的类，这里的Coffee是不能写成类型变量T的，因为必须指定实现的具体类型，
 * 实现Iterable的类就可以直接遍历了
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {}

    private int size = 0;
    public CoffeeGenerator(int size) {
        this.size = size;
    }

    /**
     * 生成一个随机的对象，通过Class.newInstance()生成对象
     * newInstance()返回的是一个Object类型，需要向下转型
     * @return
     */
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            // Coffee重写了toString()方法
            System.out.println(gen.next());
        }

        // 因为CoffeeGenerator实现了Iterable，所以才可以直接遍历这个对象
        // 这个c其实是CoffeeGenerator对象调用了它重写的next()方法得到的，Iterable迭代时，自动先调用hasNext()方法，再调用next()迭代的
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

