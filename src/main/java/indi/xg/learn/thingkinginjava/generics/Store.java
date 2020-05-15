package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.util.Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 * 从这个例子中，可以看到，用面向对象的思想来实现日常的业务是多么地简单，
 * 100行不到的代码实现了一个商店
 */

/**
 * 商品类
 */
class Product {
    // 常量不初始化，编译通不过，因为这是普通常量，属于对象，所以在构造方法中初始化也可以
    // 但如果是静态常量，是属于类的，则必须直接初始化或在静态块中初始化
    private final int id;
    private String description;
    private double price;
    private Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    /**
     * 商品价格改变
     * @param change 商品改变的数量，可正可负
     */
    public void priceChange(double change) {
        // 这是通用的，如果change是负数，就是减价
        price += change;
    }
    public static Generator<Product> generator = new Generator<Product>() {
        // 这里面整个都是一个内部类，在类里面自然可以定义变量和方法，比如rand，
        // 不要以为只能重写接口的方法
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

/**
 * 货架类，货架可以存放商品
 */
class Shelf extends ArrayList<Product> {
    /**
     * 货架中增加商品列表
     * @param nProducts 填充的商品数量
     */
    public Shelf(int nProducts) {
        // 这里的意思是给这个shelf对象添加商品列表，
        Generators.fill(this, Product.generator, nProducts);
    }
}

/**
 * 货廊，每一个货廊可以有摆多个货架
 */
class Aisle extends ArrayList<Shelf> {
    /**
     * 这个构造函数，就表示一个货廊直接摆放多个货架，每个货架的商品数量是一样的
     * @param nShelf 货廊数
     * @param nProducts 每个货廊商品数量
     */
    public Aisle(int nShelf, int nProducts) {
        for (int i = 0; i < nShelf; i++) {
            add(new Shelf(nProducts));
        }
    }
}

/**
 * 一个付款通道
 */
class CheckoutStand {}

/**
 * 办公室
 */
class Office {}

/**
 * 一个商店，可以有多个货廊
 */
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nAisles, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // 打印一个对象，就会调用这个对象重写的toString()方法，如果没有重写toString()，
        // 则会调用父类的toString()，打印的是对象的地址
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 50));
    }
}
