package indi.xg.learn.thingkinginjava.generics;

import java.util.Date;

/**
 * 泛型方法，这里的GenericMethods没有被泛型化，并不是说不能和方法同时参数化
 * 类型参数化和方法参数化是没有冲突的
 */
public class GenericMethods {
    /**
     * 定义泛型方法，必须将方法的类型参数放在返回值之前，比如这里void前的 <T>和参数列表的(T x)对应
     * @param x
     * @param <T> 方法类型参数
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        // 传入不同类型的对象，编译器会自动识别，就好像是f()被无限次重载，而不需要我们先指定方法的参数类型
        gm.f("Lily");
        // 自动打包，将int类型打包成Integer对象
        gm.f(26);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(new Date());
    }
}
