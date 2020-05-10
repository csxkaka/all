package indi.xg.learn.thingkinginjava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，不懂
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy就是传递进来的代理对象
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", arg: " + args);
        if (args != null) {
            System.out.println(" " + args);
        }
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("Lily");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // 通过Proxy的静态方法创建一个代理对象，这个代理对象属于Interface
        //
        Interface proxy = (Interface) Proxy.newProxyInstance(
                // 需要被代理的接口的类加载器
                Interface.class.getClassLoader(),
                // 希望该代理对象实现的接口列表
                new Class[]{Interface.class},
                // 一个调用处理器，传入一个实际对象的引用
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}
