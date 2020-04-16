package indi.xg.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆内存溢出场景
 * 参数配置，堆内存10m
 * -XX:InitialHeapSize=10m -XX:MaxHeapSize=10m
 */
public class HeapOOM {

    public static void main(String[] args) {

        long count = 0;
        List<Object> list = new ArrayList<>();

        while (true) {
            list.add(new Object());
            System.out.println("创建了" + ++count + "个对象");
        }
    }
    /**
     * 结果发现，10m的堆内存，差不多360000个最简单的对象可以塞满整个老年代
     */
}
