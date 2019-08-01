package com.bitongchong.codinginterviews;

/*
 * 题目描述：
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class Code_07_Fibonacci {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int a0 = 0;
        int a1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = a0 + a1;
            a0 = a1;
            a1 = res;
        }
        return res;
    }
}