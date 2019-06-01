package com.bitongchong.codingguide;

/**
 *
 */
public class Code_9_3_2_RightOne {
    public static int rightOne(int num) {
        int res = 0;
        while (num != 0) {
            num >>>= 1;
            res += num;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(rightOne(10));
    }
}
