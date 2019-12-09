package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuehe
 * @description 四数之和
 * @date 2019/12/4
 */
public class Code_018_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        // 做题的时候命名可以简单一点，可能不能满足编程风格，但是命名过长头都是大的
        int lIndex = 0;
        int rIndex = 0;
        // i < nums.length - 3; 这是因为题目是四数之和
        for (int i = 0; i < nums.length - 3; i++) {
            // 这儿也不能判断nums[j] > target, 因为这是4位数的判断，nums[j]不像三位数判断一样是最小的数
            // 每个大循环都判断一下当前最小的值是否大于目标数，如果大的话，就不用判断了
            int minRes = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minRes > target) {
                break;
            }
            // 这儿是去重， 比如 -1 -1 0 1 2 ，当i = 1时，如果不去重，那么会出现两个 -1 0 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 这儿不能判断nums[j] > target, 因为这是4位数的判断，nums[j]不像三位数判断一样是最小的数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 注意这儿是内层的 j + 1，而不是 i + 1
                lIndex = j + 1;
                rIndex = nums.length - 1;
                while (lIndex < rIndex) {
                    int calcRes = nums[i] + nums[j] + nums[lIndex] + nums[rIndex];
                    // 因为三数相加的结果只可能 > 0 || < 0 || == 0，分别对应下面三种情况
                    if (calcRes == target) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[lIndex], nums[rIndex]);
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
                    if (calcRes < target) {
                        while (lIndex < rIndex && nums[lIndex] == nums[lIndex + 1]) {
                            lIndex++;
                        }
                        lIndex++;
                    }
                    if (calcRes > target) {
                        while (rIndex > lIndex && nums[rIndex] == nums[rIndex - 1]) {
                            rIndex--;
                        }
                        rIndex--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code_018_FourSum().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        for (List<Integer> integers :
                lists) {
            System.out.println(integers);
        }
    }
}
