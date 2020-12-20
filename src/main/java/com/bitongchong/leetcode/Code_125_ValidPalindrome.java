package com.bitongchong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2020/6/19 9:49
 */
public class Code_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if ((s.charAt(left) | 0x20) != (s.charAt(right) | 0x20) && left < right) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean valid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args){
        System.out.println(new Code_125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        LinkedList<Integer> list = new LinkedList<>();
        list.add(34);
        list.add(23);
        System.out.println(list);
    }
}
