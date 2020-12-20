package com.bitongchong.review;

import java.util.HashMap;

public class Main1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }

            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Main1().checkSubarraySum(new int[]{0,0}, 0));
    }
}
