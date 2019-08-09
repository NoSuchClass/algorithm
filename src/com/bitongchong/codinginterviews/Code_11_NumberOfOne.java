package com.bitongchong.codinginterviews;

/**
 * @author liuyuehe
 * @description 二进制中1的个数
 * @date 2019/8/9
 */
public class Code_11_NumberOfOne {
    public static int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            // 如果用 >> 的话，就是带符号右移，负数的话会自动补1，导致死循环
            n = (n >>> 1);
        }
        return res;
    }

    public static int NumberOf2(int n) {
        int res = 0;
        while (n != 0) {
            // 这个是真的骚，记住就好
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-64));
        System.out.println(NumberOf2(-64));
    }
}
