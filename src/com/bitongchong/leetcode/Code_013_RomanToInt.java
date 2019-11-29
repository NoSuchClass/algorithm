package com.bitongchong.leetcode;

import java.util.HashMap;

/**
 * @author liuyuehe
 * @description 罗马数字转整数
 * @date 2019/11/28
 */
public class Code_013_RomanToInt {
    public int romanToInt(String s) {
        char[] characters = s.toCharArray();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < characters.length - 1; i++) {
            if (map.get(characters[i]) >= map.get(characters[i + 1])) {
                res += map.get(characters[i]);
            } else {
                res -= map.get(characters[i]);
            }
        }
        return res + map.get(characters[characters.length - 1]);
    }
}
