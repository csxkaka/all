package indi.xg.learn.algorithm.leetcode.simple.array;

import java.util.HashMap;

/**
 * 如果数组中一半以上的数（超过一半）是同一个数，则称这个数为主要元素
 * 给定一个数组，找到主要元素并返回，如果不存在，则返回-1
 *
 * 要求：时间复杂度为 O(N)，空间复杂度为 O(1)
 * @Author chenshixue
 * @Date 2020/2/24
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{};
        long start = System.currentTimeMillis();
        int result = majorityElement(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }

    /**
     * 参考例子：
     * 思路：可疑元素：el，计数器：count，
     *      如果后一个数与可疑元素相同，则count++，否则count--，
     *      当count==0，说明前面的几个数中，最多的那个数也只有之前的一半，不足以使命题成立，
     *      此时将下一个数作为可疑元素，
     *      计算完后，如果count==0，说明没有一个数的个数大于一半，最多只有一半，
     *      如果count>0，说明前面的抵消完后，后面的数有一个多于剩余的一半，再遍历一次，判断这个数的个数是否大于总个数的一半
     * @param nums
     * @Return  int
     * @Author  chenshixue
     * @Date    2020/2/24 22:15
     */

    // [12, -1, 12, 11, 12, 11, 13, 13, 11]
    public static int majorityElement(int[] nums) {
        int count = 0;
        int el = -1;  // 可疑元素，这里不从第一个元素开始，而是先设为-1，有个好处，避免了空指针

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (count == 0) {   // ==0，说明前面的抵消完了
                el = a;   // 把这个数赋值给可疑元素
                ++count;
            } else {
                if (el == a) {  // ==可疑元素，那么可疑元素的个数加1
                    ++count;
                } else {
                    --count;    // ！= 就抵消一个
                }
            }
        }
        if (count == 0) {   // count不可能小于0，每次抵消完，下一个就会count++
            return -1;
        }
        // 如果大于零，判断可疑元素在整个数组中是否超过半数
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (el == nums[i]) {
                ++count;
            }
        }
        return count > (nums.length / 2) ? el : -1;
    }

    /**
     * 自己写的，性能不好
     * @param nums
     * @Return  int
     * @Author  chenshixue
     * @Date    2020/2/24 21:37
     */
    // [0, -1, 12, 11, 6, 7, 12, 3, 54, 12]
    public static int majorityElement2(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i = 0; i < nums.length; i++ ){  // 时间复杂度O(N)
            if(!map.containsKey(nums[i])){  // 空间复杂度O(1)
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        Integer pre = null;
        Integer num = null;
        for(Integer key : map.keySet()){
            if(pre == null){
                pre = map.get(key);
                num = key;
                continue;
            }else{
                if(map.get(key) > pre){
                    pre = map.get(key);
                    num = key;
                }
            }

        }
        if(2 * map.get(num).intValue() > nums.length) {
            return num;
        }

        return -1;
    }
}
