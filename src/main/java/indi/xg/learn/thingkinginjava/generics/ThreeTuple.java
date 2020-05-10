package indi.xg.learn.thingkinginjava.generics;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 利用继承机制，实现更长的元组
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    // 同样需要使用final修饰
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        // 调用父类的构造函数，可以很轻松的实现元组的扩容
        super(a, b);
        this.third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}

/**
 * 如果还想继续增加元组的长度，可以继续追加
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.fourth = d;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }
}