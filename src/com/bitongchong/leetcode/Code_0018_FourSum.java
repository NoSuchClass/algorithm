package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuehe
 * @description 四数之和
 * @date 2019/12/4
 */
public class Code_0018_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }
        if (Arrays.stream(nums).allMatch(e -> e == target)) {
            res.add(Arrays.asList(0,0,0,0));
            return res;
        }
        Arrays.sort(nums);
        // 做题的时候命名可以简单一点，可能不能满足编程风格，但是命名过长头都是大的
        int lIndex = 0;
        int rIndex = 0;
        // i < nums.length - 3; 这是因为题目是四数之和
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target) {
                break;
            }
            // 这儿是去重， 比如 -1 -1 0 1 2 ，当i = 1时，如果不去重，那么会出现两个 -1 0 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 如果第一个数 > 0的话，它前面那个数也是 >0的，就不可能sum = 0
                if (nums[j] > target) {
                    break;
                }
                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }
                lIndex = i + 1;
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
                        lIndex++;
                    }
                    if (calcRes > target) {
                        rIndex--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code_0018_FourSum().fourSum(new int[]{0, 0, 0, 0}, 0);
        for (List<Integer> integers :
                lists) {
            System.out.println(integers);
        }
    }
}
