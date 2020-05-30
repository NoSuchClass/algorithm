package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/5/29 9:36
 */
public class Code_014_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new Code_014_LongestCommonPrefix().longestCommonPrefix(new String[]{"acc"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 相当于将第一个字符做为基础值，然后想象所有的字符串从上到下排列，按照每一列来进行比较，如果当前的列超出了某个字符串的长度
        // 或者是当前两个字符不相等，那么直接返回当前比较过的字符
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
