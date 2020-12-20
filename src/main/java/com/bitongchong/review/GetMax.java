package com.bitongchong.review;

import java.util.*;

public class GetMax {
    public static void main(String[] args) {
        threeSum(new int[]{0, 0, 0, 0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                return res;
            }
            if (first > 0 && nums[first] == nums[first -1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            while(second < third) {
                int curSum = nums[first] + nums[second] + nums[third];
                if (curSum == 0) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    while(second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while(second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (curSum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return res;
    }
}