package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/6/2 8:24
 */
public class Question_064_OneToNSum {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
    public static void main(String[] args){
        System.out.println(new Question_064_OneToNSum().sumNums(3));
    }
}
