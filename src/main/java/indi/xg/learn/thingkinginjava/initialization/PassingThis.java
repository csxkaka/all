package indi.xg.learn.thingkinginjava.initialization;

/**
 * this关键字
 * 1、this只存在于方法中
 * 2、this只表示当前这个类的对象的引用，或者说只表示调用当前类的方法的引用
 * 3、如果是从父类继承来的方法，this也是只当前类的对象的引用，而不是父类的引用
 * 3、如果要表示父类对象的引用，则使用super关键字
 *
 * 4、可以在构造器中使用this(xxx, xxx)，表示对当前类的某个构造器的明确调用
 * 5、super(xxx, xxx)，就表示对当前类的父类的某个构造器的明确调用
 * 6、通过this(xxx)调用某个构造器，这个this()必须放在方法最开始位置，super(xxx)也一样
 * 7、一个构造器中，最多只能用一次this(xxx)调用其他构造器，这也符合上面所说的this(xxx)必须在方法的起始位置，super(xxx)也一样
 */
public class PassingThis {

    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}

class Person {
    public void eat(Apple apple) {
        Apple apple1 = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
//    static Apple peel(Apple apple) {
//        return apple;
//    }

    Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() {
        /*
         * 这里的this指的当前对象的引用而不是Peeler对象的引用，this始终都是Apple类的某个对象的引用
         * this只会存在于某个类的方法中，其他类的方法里的this永远不可能指向Apple类的实例
         */
//        return Peeler.peel(this);


        /*
         * 将peel()方法改为实例方法，这里通过实例化一个Peeler对象，调用peel()，编译不报错，且结果正确
         * 说明这个this还是Apple的一个实例，而不是调用peel()方法的对象的引用
         */
        return new Peeler().peel(this);
    }
}