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
        // 关键点1：进行排序
        Arrays.sort(nums);
        // 循环条件为nums.length - 2
        // 注意：后续类似这样的判断，如果需要查看下外层循环是否能够满足判断所需，能够以此优化代码
//            while(first > 0 && first < nums.length - 2 && nums[first] == nums[first - 1]) {
//                first++;
//            }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 小优化，最小值大于零则代表后续不可能有三个元素的和为零
            int minRes = nums[i] + nums[i + 1] + nums[i + 2];
            if (minRes > 0) {
                return res;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            int targetSum = -nums[i];
            // 双指针
            while(leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] == targetSum) {
                    List<Integer> resNode = Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]);
                    res.add(resNode);
                    leftIndex++;
                    rightIndex--;
                    // 关键点2：得到结果后的去重
                    while(leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                    while(leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }
                } else if (nums[leftIndex] + nums[rightIndex] > targetSum) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return res;
    }
}
