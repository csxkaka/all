package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 工厂
 * @author chenshixue
 * @date 2020/5/4
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {

        // factory分别是Implementation1和Implementation2中的匿名工厂对象
        Service s = factory.getService();

        // 只打印了Implementation2中的
        // 这里的意思是s指向的是一个Implementation2类型的实例对象，对象的类型在构造的时候是可以确定地。
        if (s instanceof Implementation2) {
            s.method1();
            s.method2();
        }
    }

    public static void main(String[] args) {
        // 这里传过来的参数其实就是匿名的工厂对象，它里面有一个实现了接口的getService()方法
        // 这个方法专门用来创建Implementation1对象的
        serviceConsumer(Implementation1.factory);

        // 同上
        serviceConsumer(Implementation2.factory);
    }
}

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    // 这里可以是私有的，隐藏对象的构造过程
    private Implementation1() {}

    // 这个工厂负责创建Implementation1对象，没有必要创建工厂的具名类
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

class Implementation2 implements Service {

    private Implementation2() {}

    // 这个工厂负责创建Implementation2对象，没有必要创建工厂的具名类
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

