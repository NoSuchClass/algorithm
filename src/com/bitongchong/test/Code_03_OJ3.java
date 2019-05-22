package com.bitongchong.test;

public class Code_03_OJ3 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int i = 1;
        int count = 0;
        int k;
        while ((n / i) != 0) {
            k = n % (10 * i);
            if (k > 2 * i - 1) {
                count += i;
            } else if (k >= i && k < 2 * i - 1) {
                count += 2 * i - 1;
            }
            i *= 10;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(new Code_03_OJ3().NumberOf1Between1AndN_Solution(1));
    }
}