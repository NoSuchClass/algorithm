package com.bitongchong.leetcode;

import java.util.HashSet;

/**
 * @author liuyuehe
 * @date 2020/6/6 19:40
 */
public class Code_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestLength = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curLength = 1;
                while(set.contains(num + 1)) {
                    curLength += 1;
                    num += 1;
                }
                longestLength = Math.max(curLength, longestLength);
            }
        }
        return longestLength;
    }
}
