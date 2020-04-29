package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/27 11:11
 */
public class Code_034_FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 跳出的条件为 left + 1 = right，因此left有三种情况
        // 第一种情况 nums=[8], target=5：触发nums[mid] > target条件，right向左越界数组，跳出while，代表所有数组元素都大于target
        //              此时需要判断nums[left]==target
        // 第二种情况 nums=[5], target=8：触发nums[mid] < target条件，left向右越界数组，跳出while，代表所有数组元素都小于target
        //              此时需要判断left==nums.length
        // 第三种情况 nums=[8,9], target=8：触发nums[mid] == target条件，right右移，令right<left，跳出while，代表查找到左边界
        //              left，直接返回
        while(left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right == -1 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
