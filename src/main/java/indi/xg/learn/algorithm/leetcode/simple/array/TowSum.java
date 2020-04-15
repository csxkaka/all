package indi.xg.learn.algorithm.leetcode.simple.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 给定一个整数数组nums[]和一个目标值target
 * 在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @Author chenshixue
 * @Date 2020/2/23
 */
public class TowSum {

    // [2,5,5,10,11] -----10

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,5,5,2,10,5};
        int target = 7;
        int[] arr = twoSum(nums, target);
        List<int[]> arrList = towSumList(nums, target);
        System.out.println("===========");
    }

    /**
     * 找出一对数组即可的解法
     * @param nums
     * @param target
     * @Return  int[]
     * @Author  chenshixue
     * @Date    2020/2/23 14:15
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            // 补数存在
            if (map.containsKey(nums[i])) {
                index[1] = i;  // 补数应该为第二个
                index[0] = map.get(nums[i]);  // nums[i]是补数，对应的值是第一个数的下标
                return index;
            }

            // k--补数（第二个数）    v--第一个数的下标
            map.put(target - nums[i], i);
        }
        return null;
    }

    /**
     * 找出所有可能
     * @param nums
     * @param target
     * @Return  java.util.List<int[]>
     * @Author  chenshixue
     * @Date    2020/2/23 14:54
     */
    public static List<int[]> towSumList(int[] nums, int target) {

//        long start = System.currentTimeMillis();

        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>(nums.length);
        // 先全部存进来
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int[] index;
            int remain = target - nums[i];

            for (int j = i; j < nums.length; j++) {
                if (map.get(j).intValue() == remain) {  // 如果两数相等
                    index = new int[2];
                    index[0] = i;
                    index[1] = j;
                    result.add(index);
                }
            }
        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        return result;
    }
}
