package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/7/1 7:43
 */
public class Code_718_MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        System.out.println(new Code_718_MaximumLengthOfRepeatedSubarray().findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] A, int[] B) {
        // 因为后面填充dp数组的时候需要使用双重循环来判断，并且需要使用到dp[i - 1][j - 1]这种数组，那么i和j的起始位置一定是从1开始的
        // 但是此是就需要额外对i=0，和j=0的所有dp[0][j]和dp[i][0]进行初始化，而实际上初始化的规则是和dp数组填充规则相同的，因此可以直接
        // 将dp数组的容量增大一位，用dp[1][j]这种数组来存储A[0]和B数组的匹配情况。
        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                // 此处的if条件判断实际上是从尾部出发（参考编辑距离这道题），来判断尾部的最长公共前缀，比如
                // 1,2,3和6,2,3此时是从尾部出发来看，最长的相同前缀是2,3，因此此处可以存一个2，如果1,2,3和6,2,3,2，此时的前缀实际上
                // 不可能相同的，因此直接为0（一定要注意此处查找的是公共的且长度最长的子数组，可以直接用一个变量来存储这个子数组的长度，
                // 而不需要使用dp数组来存储递推下去）
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}
