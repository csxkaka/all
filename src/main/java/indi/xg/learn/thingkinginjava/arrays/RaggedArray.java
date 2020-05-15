package indi.xg.learn.thingkinginjava.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 多维数组
 */
public class RaggedArray {
    public static void main(String[] args) {
        Random rand = new Random(47);

        // 定义多维数组时，最外层数组必须设一个长度，内层的如果没有设长度，就自动为null
        int[][][] a = new int[rand.nextInt(7)][][];
        // Arrays.deepToString()可以将数组转换为字符串，可以方便的查看多维数组的结构
        System.out.println(Arrays.deepToString(a));

        for (int i = 0; i < a.length; i++) {
            // 初始化第二层数组长度，第二层数组的元素还是数组，会自动初始化为null
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                // 初始化第三层数组长度，第三层数组的元素是int类型，就会自动初始化为0
                a[i][j] = new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
