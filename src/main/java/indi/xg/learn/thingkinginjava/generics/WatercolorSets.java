package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

public class WatercolorSets {

    public static void main(String[] args) {
        // EnumSet是JDK5新增的api，可以将枚举从一个范围直接创建为一个Set
        // 从这里也可以看出，有时候枚举属性的声明顺序也是需要关注的
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUB);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        System.out.println(set1);
        System.out.println(set2);

        // 取并集
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
        // 取交集
        Set<Watercolors> subset = Sets.intersection(set1, set2);

        System.out.println("intersection(set1, set2): " + subset);
        // 取不同
        System.out.println("difference(set1, subset): " + Sets.difference(set1, subset));
        // 取不同
        System.out.println("difference(set2, subset): " + Sets.difference(set2, subset));
        // 取两者交集之外的所有
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
