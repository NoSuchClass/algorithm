package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 32位整数反转
 * @date 2019/11/24
 */
public class Code_007_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int temp = 0;
        while (x != 0) {
            temp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)){
                return 0;
            }
            res = res * 10 + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code_007_ReverseInteger().reverse(-12323441));
    }
}
