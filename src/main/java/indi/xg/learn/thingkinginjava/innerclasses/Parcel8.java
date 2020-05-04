package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 匿名内部类，传递参数，基类为普通类
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel8 {


    // 这里的Wrapping是个普通的类，它有一个传递一个参数的构造器
    public Wrapping wrapping(int x) {

        // 通过这种形式来构建一个Wrapping类的子类的一个对象，这个子类是匿名的，我们不知道它的具体名字，
        // 但它一定是Wrapping的一个子类，而且这个子类对象一定是向上转型为Wrapping的。

        // 这个参数是必传的，因为Wrapping只有一个带有一个参数的构造器
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    // 基类有多少种构造器，就有多少种创建方式
    // 但基类如果是接口，则只有以各种创建方式，就是不带参数的
    public Wrapping wrapping(int x, String y) {
        return new Wrapping(x, y) {
            @Override
            public int value() {
                return super.value();
            }
        };
    }
}
