package indi.xg.learn.thingkinginjava.generics;

import java.util.*;

/**
 * 匿名内部类使用泛型
 */
class Customer {
    private static long counter = 1;
    private final long id = counter++;
    // 私有构造方法，就说明不能在其他类中创建该对象，强制要求使用生成器来生成对象
    private Customer() {}

    @Override
    public String toString() {
        return "Customer " + id;
    }
    public static Generator<Customer> generator() {
        // Generator是一个泛型接口，是不能直接创建该对象的，必须通过匿名内部类的形式创建该接口的实现类
        // 又因为该接口是一个泛型接口，所以就需要传一个实体类，传的什么类，返回的就是什么类的对象
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}

    @Override
    public String toString() {
        return "Teller " + id;
    }
    public static Generator<Teller> generator = new Generator<Teller>() {
        // 实现接口的next方法
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        // 这里填充的是line这个队列
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        // 这里填充的是tellers这个集合
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}
