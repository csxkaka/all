package indi.xg.learn.thingkinginjava.typeinfo;

import java.util.Random;

/**
 * 通过类字面量获取Class对象引用时，Class对象的初始化时间
 * 一个类只有一个Class对象
 */
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        // 通过类字面量获取Class对象引用，Class对象不会初始化
        Class initable = Initable.class;
        // 上一步走完，没有执行Initable中的静态快，说明该Class对象还没有初始化
        System.out.println("After creating Initable ref");

        // 通过类访问staticFinal属性，仍然没有执行Initable中的静态块
        // staticFinal是类的编译期常量，在编译的时候已经知道了具体的值，
        // 所以不需要初始化Class对象，常量有确切的值，且常量是不可变的，那么staticFinal的值就一定是这个常量了
        System.out.println(Initable.staticFinal);

        // 同样是static final的常量，但staticFinal2不是编译期期常量，
        // 编译的时候不知道其具体的值，因此在访问staticFinal2属性的时候
        // 就必须先初始化Class对象，一旦初始化这个对象，就会会初始化静态域
        // 所以这里会先执行静态块，然后打印staticFinal2的值
        System.out.println(Initable.staticFinal2);

        // staticNonFinal只是普通的静态属性，在访问此属性时，一定会先初始化Class对象
        System.out.println(Initable2.staticNonFinal);

        // 通过Class.forName()获取，直接就会先初始化该Class对象
        Class initable3 = Class.forName("indi.xg.learn.thingkinginjava.typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        // 获取Class对象的引用还有一种方式，就是通过对象的getClass()方法，这个获取Class对象引用
        // 那么这个Class对象肯定是已经初始化了的
    }
}

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
