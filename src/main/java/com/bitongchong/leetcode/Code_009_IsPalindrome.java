package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 回文数判断
 * @date 2019/11/27
 */
public class Code_009_IsPalindrome {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int mid = chars.length / 2;
        for (int i = 0; i <= mid; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不转换为str实现反转
     */

    public boolean isPalindromePlus(int x) {
        // 此处注意判断当末尾为零时，数字不可能为回文数字，同时↓
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x / 10;
            x /= 10;
        }
        // 如果有0的条件，那么类似 10 这种，就会被后一个条件漏掉
        return reverseNum == x || reverseNum / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(new Code_009_IsPalindrome().isPalindrome(4097));
    }
}
