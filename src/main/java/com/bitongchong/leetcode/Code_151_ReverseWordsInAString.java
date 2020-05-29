package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/5/29 11:08
 */
public class Code_151_ReverseWordsInAString {
    public static void main(String[] args){
        System.out.println(new Code_151_ReverseWordsInAString().reverseWords(
                "a good   example"));
    }
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = s.length() - 1, j = i;
        StringBuilder stringBuilder = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            stringBuilder.append(s.substring(i + 1, j + 1)).append(" ");
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return stringBuilder.toString().trim();
    }
}
