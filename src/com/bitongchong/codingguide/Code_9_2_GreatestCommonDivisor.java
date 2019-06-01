package com.bitongchong.codingguide;

/**
 * 两个非零整数，求最大公约数
 */
public class Code_9_2_GreatestCommonDivisor {
    // 这儿如果m n的大小不确定的话，其实也可以计算的，因为 2 % 100 = 2， 下一个循环就是 100 % 2了
    public static int gcd(int m, int n){ return n == 0 ? m : gcd(n, m % n);}
    public static void main(String[] args){ System.out.println(gcd(-14, 2)); }
}
