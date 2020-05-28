package com.bitongchong.leetcode;

import static java.lang.Character.isDigit;

/**
 * @author liuyuehe
 * @date 2020/5/26 15:39
 */
public class Code_044_WildcardMatching {
    /**
     * 主要是将视角转换到了两个字符串对于最后一个字符的匹配上面，然后查看这两个字符的匹配与前面的匹配结果是否有关系
     * 而这个地方显然是有关系的，
     * 比如
     * [a, a, a]和[a, a, ?]
     * [a, a, a]和[a, b, ?]
     * [a, a, a]和[a, b, a]
     * 从最后一个字符来看，由于?能够匹配一个任意的字符，因此是能够匹配的，由于最后一个字符能够匹配，那么整体是否能够匹配就取决于除该
     * 字符外的前面所有字符是否匹配，因此完成 ? 这种情况的匹配
     * [a, a, a]和[a, a, *]
     * [a, a, a]和[a, *]
     * 对于 * 这种情况，和 ? 这种情况有所不同，由于它能够匹配一个或者多个字符或者空字符串，因此对于这两种情况分别进行分析：
     * A-匹配多个（包括一个）
     * 如何判断匹配多个呢？查看情况5可以知道，匹配多个的情况相当于是判断除最后一个字符外的前面整体，与当前的p串进行比较
     * @param s -
     * @param p -
     * @return -
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 这儿实际上隐藏了一个对于 s字符串存在，但是p字符串为空的情况，因为一定会为false，并且这个是dp的默认值，因此省去
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    // 此处是匹配一个的情况，是匹配多个的特殊情况（匹配多个的表达式：dp[i - 1][j]）
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    // 此处是匹配多个和匹配0个的表达式
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        System.out.println(new Code_044_WildcardMatching().isMatch("aaa", "a"));
    }
}
