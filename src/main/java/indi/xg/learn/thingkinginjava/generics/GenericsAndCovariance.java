package indi.xg.learn.thingkinginjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // 这里的意思，某一种flist引用没有指定任何类型，
        // 所以下方的代码，编译都无法通过
        List<? extends Fruit> flist = new ArrayList<Apple>();

        // 编译都失败
//        flist.add(new Apple());
//        flist.add(new Fruit());
        // 包括Fruit和Object都无法通过
//        flist.add(new Object());

        // 只能添加null，但这似乎没有意义
        flist.add(null);
        // 返回的仍是Fruit
        Fruit fruit = flist.get(0);
    }
}
