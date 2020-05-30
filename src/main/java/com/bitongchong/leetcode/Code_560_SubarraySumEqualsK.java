package com.bitongchong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuehe
 * @date 2020/5/27 13:02
 */
public class Code_560_SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(new Code_560_SubarraySumEqualsK().subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        memo.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int index = preSum - k;
            if (memo.containsKey(index)) {
                ans += memo.get(index);
            }
            memo.put(preSum, memo.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
