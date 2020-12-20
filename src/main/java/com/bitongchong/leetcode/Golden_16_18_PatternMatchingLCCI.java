package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/6/22 14:49
 */
public class Golden_16_18_PatternMatchingLCCI {
    public boolean patternMatching(String pattern, String value) {
        String a = "";
        String b = "";
        for (int i = 0; i < value.length(); i++) {
            a = i == 0 ? "" : value.substring(0, i);
        }
        return false;
    }
}
