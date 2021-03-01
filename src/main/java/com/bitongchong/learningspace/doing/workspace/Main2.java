package com.bitongchong.learningspace.doing.workspace;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuehe
 * @date 2021/1/24 12:02
 */
public class Main2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new Main2().isAnagram("a", "aa"));
    }
}
