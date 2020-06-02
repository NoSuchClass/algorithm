package com.bitongchong.leetcode;

import java.util.HashMap;

/**
 * @author liuyuehe
 * @date 2020/5/27 16:34
 */
public class Code_523_ContinuousSubarraySum {
    // 结合974，如果要在Java中使用同余定理
    // 比如 a % k 那么：
    // a >= 0, k正负数均有 -> (a - b) % k == 0 -> a % k == b % k
    // a正负数均有，k > 0 -> (a - b) % k == 0 -> ((a % k) + k) % k == ((b % k) + k) % k  [这儿主要是处理一下被除数]
    public static void main(String[] args) {
        System.out.println(new Code_523_ContinuousSubarraySum().checkSubarraySum(new int[]{2}, 1));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        // 此处不能使用建立K大小的数组来优化，因为K可能为负数，使用数组来存不方便处理，直接使用HashMap会方便很多，因为可以直接存储
        // K为负数情况下的余数（因为数组中所有元素都是正整数，可以直接使用同余定理，需要注意的是，如果需要再Java中使用同余定理，只需
        // 要将被除数处理为正数即可，对于除数，只需要注意一些特殊地方，0 和 1即可）
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        // 细节处理：能够保证[2,3] k=1和[2,4] k=2这种情况，避免后续i - map.get(sum) > 1不能够正确判断
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 较好地处理了 k = 0 的这种情况，当k为0的时候，直接让数组元素相加，存入map中
            if (k != 0) {
                // 因为 sum 一定是正整数，那么 (sum % k) % k 实际上的结果是相同的，因此可以直接使用sum作为hash表的key来使用
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                // 由于在存储对应的余数时，也存储了对应的数组索引，因此可以通过对应的索引相减来判断是否满足题目中要求的连续且至少两个
                // 这个条件
                if (i - map.get(sum) > 1) {
                    return true;
                }
                // 只能在map中不存在当前计算出的余数后，才将值存入，避免 [1,1] k = 1的这种情况
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
