package indi.xg.learn.thingkinginjava.generics;

import java.util.ArrayList;

/**
 * 泛型创建List元组，继承ArrayList
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        // 刚才先写 new TupleList<Amphibian, Vehicle, String, Integer>();
        // 然后使用Ctrl+Alt+V生成变量，自动将右边的泛型去掉了，还挺好用
        // 以后生成变量应该多用快捷建，从左向右编程，从对象到引用编程，先确定对象，在给变量一个引用
        TupleList<Amphibian, Vehicle, String, Integer> tl = new TupleList<>();
        // TupleList继承了ArrayList，所以有add方法，add里只能添加FourTuple类型
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());

        // 尽管泛型不写会简洁点，但还是要写上，尽量不要出现警告
        for (FourTuple<Amphibian, Vehicle, String, Integer> i : tl) {
            System.out.println(i);
        }
    }
}