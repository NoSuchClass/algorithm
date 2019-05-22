package com.bitongchong.nowcodeplus;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 【题目】 给定数组arr和整数num,共返回有多少个子数组满足如下情况
 * max(arr[i..j])-min (arr [i..j])< num
 * max(ar[i..j])表示子数组arr[i..j]中的最大值,min(arr[i..j])表示子数组arr[i..j]中的最小值。
 * 【要求】 如果数组长度为N,请实现时间复杂度为0(N)的解法。
 */
public class Code_2_3_AllLessNumSubArray {
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length < 1) return 0;
        int res = 0;
        int L = 0;
        int R = 0;
        LinkedList<Integer> minList = new LinkedList<>();
        LinkedList<Integer> maxList = new LinkedList<>();
        while (L < arr.length) {
            while (R < arr.length) {
                while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[R]) {
                    minList.pollLast();
                }
                minList.add(R);
                while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[R]) {
                    maxList.pollLast();
                }
                maxList.add(R);
                if (arr[maxList.peekLast()] - arr[minList.peekLast()] > num) break;
                R++;
            }
            // 这儿为什么是用的L来进行过期与否的比较呢？
            if (maxList.peekFirst() == L) maxList.pollFirst();
            if (minList.peekFirst() == L) minList.pollFirst();
            res += R - L;
            L++;
        }
        return res;
    }
}
