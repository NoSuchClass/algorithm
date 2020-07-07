package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/7/4 21:16
 */
public class Question_015_TheNumberOf1InBinary {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(
                123));
    }
}
