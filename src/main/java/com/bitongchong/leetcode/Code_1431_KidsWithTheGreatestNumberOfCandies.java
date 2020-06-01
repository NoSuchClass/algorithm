package com.bitongchong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2020/6/1 11:15
 */
public class Code_1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> resList = new LinkedList<>();
        for (int candy : candies) {
            boolean res = candy + extraCandies >= max;
            resList.add(res);
        }
        return resList;
    }
}
