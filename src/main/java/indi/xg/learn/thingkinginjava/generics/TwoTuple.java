package indi.xg.learn.thingkinginjava.generics;

/**
 * 元组（tuple），实现将一组对象直接打包存储于其中的一个单一的象。
 * 这个元组允许读取其中的元素（对象），但不允许存放新的对象
 * 这里就是把A，B都存入TwoTuple对象中
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B> {
    // 使用final修饰，保证客户端程序员不能赋予first和second新的值
    // 如果确实希望客户端程序员能够改变元组容器中的对象，就强制要求他们创建一个新的TwoTuple对象
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
