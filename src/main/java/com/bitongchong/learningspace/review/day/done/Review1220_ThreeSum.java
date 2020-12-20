package com.bitongchong.learningspace.review.day.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2020/12/20 10:44
 */
public class Review1220_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 注意：后续类似这样的判断，如果需要查看下外层循环是否能够满足判断所需，能够以此优化代码
//            while(first > 0 && first < nums.length - 2 && nums[first] == nums[first - 1]) {
//                first++;
//            }
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
                    while(third > second && nums[third] == nums[third + 1]) {
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
