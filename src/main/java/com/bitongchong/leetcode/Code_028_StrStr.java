package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 实现 strStr()：留坑，后面使用KMP算法解决
 * @date 2019/12/3
 */
public class Code_028_StrStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Code_028_StrStr().strStr("hello", "ll"));
    }
}
