package com.bitongchong.codingguide;

/**
 *
 */
public class Code_9_3_1_ZeroNum {
    // 初级实现，计算每个数含有多少个因子5
    public static int zeroNum0(int num) {
        int res = 0;
        int cur = 0;
        for (int i = 5; i < num + 1; i += 5) {
            cur = i;
            while(cur % 5 == 0){
                res++;
                cur /= 5;
            }
        }
        return res;
    }

    // 中级实现，需要调用Math.pow方法
    public static int zeroNum1(int num) {
        int res = 0;
        for (Integer i = 1; Math.pow(5, i) < num + 1; i++) {
            res += num / Math.pow(5, i);
        }
        return res;
    }

    // 最优解，让num的值整体 ÷5，下一次计算的时候就相当于÷25了
    public static int zeroNum2(int num) {
        int res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zeroNum2(1000000000));
    }
}
