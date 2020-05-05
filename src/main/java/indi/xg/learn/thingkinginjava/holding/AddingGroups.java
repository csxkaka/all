package indi.xg.learn.thingkinginjava.holding;

import java.util.*;

/**
 * 集合一次添加一组元素
 * @author chenshixue
 * @date 2020/5/4
 */
public class AddingGroups {

    public static void main(String[] args) {

        // Arrays.asList()参数为一个数组或一个用逗号分隔的可变参数列表
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};

        // addAll()，参数为数组
        collection.addAll(Arrays.asList(moreInts));

        // Collections工具类，参数为一个集合和一个用逗号分隔的可变参数列表
        // 通过工具类添加的效率是最快的
        Collections.addAll(collection, 11, 12, 13, 14, 15);

        // Collections工具类，参数为一个集合和一个数组
        Collections.addAll(collection, moreInts);
        System.out.println(collection);

        // Arrays.asList()可返回一个集合，但底层其实是一个数组，所以对其进行添加或删除时，会引发改变数组带来的性能问题
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);

        // 根据索引直接修改集合内的值
        list.set(1, 99);
        System.out.println(list);
    }
}
