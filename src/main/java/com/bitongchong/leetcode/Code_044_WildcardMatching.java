package com.bitongchong.leetcode;

import static java.lang.Character.isDigit;

/**
 * @author liuyuehe
 * @date 2020/5/26 15:39
 */
public class Code_044_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        System.out.println(new Code_044_WildcardMatching().isMatch("", "*"));
    }
}
