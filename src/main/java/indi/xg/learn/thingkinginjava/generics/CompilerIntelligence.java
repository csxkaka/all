package indi.xg.learn.thingkinginjava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编译器其实并不是很聪明
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);

        // contains和indexOf()不涉及任何操作符，他们接收的类型就是Object，所以编译器允许这样的调用
        boolean b = flist.contains(new Apple());
        int i = flist.indexOf(new Apple());
        System.out.println();

        // 这里的编译是无法通过的，因为add()方法接收的参数是和泛型相关的，
        // 泛型是什么，接受的额是什么类型，所以此时的add()方法参数已经变成了"? extends Fruit"，
        // 编译器不知道接收的具体是什么类型，于是编译无法通过
//        flist.add(new Apple());

    }
}
