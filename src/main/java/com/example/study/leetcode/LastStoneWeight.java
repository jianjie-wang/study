package com.example.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1046.最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 *
 * @author: WangJJ
 * @create: 2020-12-30 17:47
 **/
public class LastStoneWeight {
    public static void main(String[] args) {

        int[] stone = {2, 7, 4, 1, 8, 1};
        System.out.println(Arrays.toString(stone));
        int i = lastStoneWeight(stone);
        System.out.println(i);
        lastStoneWeights(stone);
    }


    //递归
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;
        return lastStoneWeight(stones);
    }


    //循环
    public static int lastStoneWeights(int[] stones) {
        int len = stones.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(stones[i]);
        }
        while (list.size() > 1) {
            int[] tmp = SelectMaxInArray(list);
            list.remove(tmp[0]);
            int[] tmp1 = SelectMaxInArray(list);
            list.remove(tmp1[0]);
            if (Math.abs(tmp[1] - tmp1[1]) == 0) {
                continue;
            }
            list.add(Math.abs(tmp[1] - tmp1[1]));
        }
        if (list.size() == 0) {
            return 0;
        }
        System.out.println(list.get(0));
        return list.get(0);

    }

    public static int[] SelectMaxInArray(List<Integer> list) {
        int len = list.size();
        int[] result = new int[2];
        Arrays.fill(result, 0);//填充数组
        for (int i = 0; i < len; i++) {
            if (result[1] < list.get(i)) {
                result[0] = i;
                result[1] = list.get(i);
            }
        }
        return result;
    }

}
