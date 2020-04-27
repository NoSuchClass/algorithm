package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/4/26 11:42
 */
public class Code_354_RussianDollEnvelopes {
    public static void main(String[] args) {
        System.out.println(new Code_354_RussianDollEnvelopes().maxEnvelopes(new int[][]{{30,50}, {12,2}, {3,4}, {12,15}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes.length == 1) {
            return envelopes.length;
        }
        // 排序规则：因为套娃的时候，要求宽度和高度都要大于被套的那个娃，并且需要注意的是，如果有一个[10， 5]的娃，去套[3, 4], [3, 5]
        // 的两个娃，只有[3, 4]能够满足条件，因此，宽度如果相同，因此首先按照宽度升序进行排序，如果宽度相同，那么在宽度排序的基础上，再
        // 对长度进行降序排序，这样可以保证在两个宽度相同并且满足套娃条件的娃中只选取一个
        // 这个解法的关键在于，对于宽度 w 相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证
        // 在 w 相同的数对中最多只选取一个（主要还是因为是使用最长递增子序列来做的，因此需要考虑到最长子序列的特性来解题）。
        // 举例：[[1,3], [4,5], [4,3], [6,7]]，逆序排序可以避免[4,3]已经套进[6,7]去了，[4,5]还需要套进去，然而他们两个宽度是相同的
        // 不应该能够被套进去
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]++;
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
