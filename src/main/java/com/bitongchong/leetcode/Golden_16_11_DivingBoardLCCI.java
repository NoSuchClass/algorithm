package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author liuyuehe
 * @date 2020/7/8 7:42
 */
public class Golden_16_11_DivingBoardLCCI {
    public static void main(String[] args){
        int[] ints = new Golden_16_11_DivingBoardLCCI().divingBoard2(1, 2, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    ArrayList<Integer> list = new ArrayList<>();

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        process(shorter, longer, k, 0);
        Collections.sort(list);
        int[] res = new int[k + 1];
        res[0] = list.get(0);
        int cur = 1;
        for (Integer integer : list) {
            if (res[cur - 1] != integer) {
                res[cur++] = integer;
            }
        }
        return res;
    }

    public void process(int shorter, int longer, int k, int sum) {
        if (k == 0) {
            list.add(sum);
            return;
        }
        sum += longer;
        process(shorter, longer, k - 1, sum);
        sum -= longer;
        sum += shorter;
        process(shorter, longer, k - 1, sum);
    }

    public int[] divingBoard2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }
}
