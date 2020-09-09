package com.example.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: study
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *               你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 ** @author: WangJJ
 * @create: 2020-07-24 16:51
 **/
public class Liangshuzhihe {

    public static void main(String[] args) {
//        int[] ints = twoSum(new int[]{4,5,8,1,8,9,3,9},10);
        int[] ints = mapTest(new int[]{4,5,8,1,8,9,3,9},10);
        System.out.println(java.util.Arrays.toString(ints));
    }


    //方法一：暴力循环，时间复杂度为O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        if (target <= 1){
            return null;
        }
        int[] ints = new int[2];
        for (int i = 0 ; i<nums.length;i++){
            for (int j = 0 ;j <nums.length; j++ ){
                if ( nums[i] + nums[j] == target && i!=j){
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return null;
    }

    //方法二：利用hashmap，时间复杂度为O(n)
    public static int[] mapTest(int[] sums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ;i<sums.length;i++){
            map.put(sums[i],i);
        }
        for (int j =0; j <sums.length; j++){
            int result = target-sums[j];
            if (map.containsKey(result)&&map.get(result)!=j){
                return new int[] {j,map.get(result)};
            }
        }
        return null;
    }




}
