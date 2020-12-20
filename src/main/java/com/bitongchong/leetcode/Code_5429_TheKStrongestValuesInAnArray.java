package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author liuyuehe
 * @date 2020/6/7 10:46
 */
public class Code_5429_TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(len - 1) >> 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : arr) {
            list.add(value);
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            if (Math.abs(o1 - m) > Math.abs(o2 - m)) {
                return -1;
            } else if (Math.abs(o1 - m) == Math.abs(o2 - m) && o1 > o2) {
                return -1;
            } else {
                return 1;
            }
        };
        list.sort(comparator);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] getStrongest2(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(len - 1) >> 1];
        int[][] temp = new int[len][2];
        for (int i = 0; i < len; i++) {
            temp[i][0] = Math.abs(arr[i] - m);
            temp[i][1] = i;
        }
        return new int[]{1};
    }

    public static void main(String[] args){
        new Code_5429_TheKStrongestValuesInAnArray().getStrongest(new int[]{1,2,3,4,5}, 2);
    }
}
