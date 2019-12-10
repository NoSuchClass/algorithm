package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuehe
 * @description 三数之和 ： 这道题的主要难点在于去重
 * @date 2019/12/3
 */
public class Code_015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        // 做题的时候命名可以简单一点，可能不能满足编程风格，但是命名过长头都是大的
        int lIndex = 0;
        int rIndex = 0;
        // i < nums.length - 2; 这是因为题目是三数之和
        for (int i = 0; i < nums.length - 2; i++) {
            // 判断当前最大循环的最小值是否大于目标值，如果大于的话，就没有必要继续循环，
            // 当然，由于这儿是和为零，那么直接判断num[i]是否 > 0即可
            int minRes = nums[i] + nums[i + 1] + nums[i + 2];
            if (minRes > 0) {
                break;
            }
            // 这儿是去重， 比如 -1 -1 0 1 2 ，当i = 1时，如果不去重，那么会出现两个 -1 0 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lIndex = i + 1;
            rIndex = nums.length - 1;
            while (lIndex < rIndex) {
                int calcRes = nums[i] + nums[lIndex] + nums[rIndex];
                // 因为三数相加的结果只可能 > 0 || < 0 || == 0，分别对应下面三种情况
                if (calcRes == 0) {
                    List<Integer> integers = Arrays.asList(nums[i], nums[lIndex], nums[rIndex]);
                    res.add(integers);
                    // 去重
                    while (lIndex < rIndex && nums[lIndex] == nums[lIndex + 1]) {
                        lIndex++;
                    }
                    // 去重
                    while (rIndex > lIndex && nums[rIndex] == nums[rIndex - 1]) {
                        rIndex--;
                    }
                    lIndex++;
                    rIndex--;
                }
                // 下面两种情况也可以去重
                if (calcRes < 0) {
                    lIndex++;
                }
                if (calcRes > 0) {
                    rIndex--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code_015_ThreeSum().threeSum(new int[]{0, 0, 0});
        for (List<Integer> integers :
                lists) {
            System.out.println(integers);
        }

    }
}
