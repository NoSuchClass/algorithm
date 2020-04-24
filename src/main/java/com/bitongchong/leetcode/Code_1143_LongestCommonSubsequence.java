package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/24 9:39
 */
public class Code_1143_LongestCommonSubsequence {
    char[] arr1;
    char[] arr2;

    public static void main(String[] args) {
        System.out.println(new Code_1143_LongestCommonSubsequence().longestCommonSubsequence1("mhunuzqrkzsnidwbun"
                , "szulspmhwpazoxijwbq"));
    }

    /**
     * 递归的解法，可以通过这个递归来推导出对应的DP解法
     *
     * @param text1 -
     * @param text2 -
     * @return -
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        arr1 = text1.toCharArray();
        arr2 = text2.toCharArray();
        // 从尾到头递归的原因是：为了更好地推导出DP解法
        return process(arr1.length - 1, arr2.length - 1);
    }

    private int process(int len1, int len2) {
        if (len1 == -1 || len2 == -1) {
            return 0;
        }
        // 如果某个字符在两个字符串中都存在，那么两个字符串数组都向前移动一位，同时给结果 +1
        if (arr1[len1] == arr2[len2]) {
            return process(len1 - 1, len2 - 1) + 1;
        } else {
            // 如果这个位置两个字符串的字符不相等，那么有两种情况，字符串数组1向前退一个，继续递归，并且获得的LCS最大，反之
            // 就是数组2向前退一个后，获得的LCS最大
            return Math.max(process(len1 - 1, len2), process(len1, len2 - 1));
        }
    }

    /**
     * 实际上，基本上所有的递归都能够改成DP来做，因为这个就是使用DP数组来存储部分在递归中已经计算出的结果，进行穷举 + 剪枝
     * 为啥这个问题就是动态规划来解决呢？因为子序列类型的问题，穷举出所有可能的结果都不容易，而动态规划算法做的就是穷举 + 剪枝，
     * 它俩天生一对儿。所以可以说只要涉及子序列问题，十有八九都需要动态规划来解决，往这方面考虑就对了。
     *
     * @param text1 -
     * @param text2 -
     * @return -
     */
    public int longestCommonSubsequence(String text1, String text2) {
        arr1 = text1.toCharArray();
        arr2 = text2.toCharArray();
        int[][] dp = new int[arr1.length][arr2.length];
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < arr1.length; i++) {
            dp[i][0] = arr1[i] == arr2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < arr2.length; i++) {
            dp[0][i] = arr1[0] == arr2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[arr1.length - 1][arr2.length - 1];
    }
}
