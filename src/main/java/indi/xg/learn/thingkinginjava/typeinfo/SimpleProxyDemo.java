package indi.xg.learn.thingkinginjava.typeinfo;

/**
 * 代理
 */
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.doSomething();
    }
}

public class SimpleProxyDemo {
    // consumer()一开始并不知道获取的具体对象是什么，在运行的时候通过iface这个引用指向的具体对象，
    // 才知道要执行哪个实现类对象的方法
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("Lily");
    }

    public static void main(String[] args) {
        // 这里会直接执行RealObject中的方法
        consumer(new RealObject());

        // 同样这里会执行SimpleProxy中实现的方法，SimpleProxy的构造器接收一个Interface接口，
        // 接口的具体实现是这里的new RealObject()对象，
        // 所以SimpleProxy.doSomething()方法下的“proxied.doSomething();”的proxy指向的是RealObject对象
        consumer(new SimpleProxy(new RealObject()));
    }
}
