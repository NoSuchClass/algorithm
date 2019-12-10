package com.bitongchong.leetcode;

import java.util.HashMap;

/**
 * @author liuyuehe
 * @description 无重复字符的最长子串
 * @date 2019/7/30
 */
public class Code_003_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int cur = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                int existNum = hashMap.get(chars[i]);
                hashMap.clear();
                for (int j = existNum + 1; j <= i; j++) {
                    hashMap.put(chars[j], j);
                }
                cur = i - existNum;
                res = res > cur ? res : cur;
            } else {
                hashMap.put(chars[i], i);
                cur++;
                res = res > cur ? res : cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
