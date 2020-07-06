package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/7/4 13:34
 */
public class Code_032_LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Code_032_LongestValidParentheses().longestValidParentheses("((())())(()))" +
                "(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()(" +
                ")))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(()" +
                ")()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((" +
                "()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()" +
                "()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())((" +
                ")((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()(" +
                ")()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())((" +
                "))))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()(((" +
                ")))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((())))" +
                ")()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))(" +
                ")))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())(" +
                "))()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()" +
                "(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))((" +
                ")())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()())" +
                ")((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()((((" +
                "(()(()))))()()((()())((()())()(())((()))()()(()))"));
       // System.out.println(new Code_032_LongestValidParentheses().isValid("(()()())", 0, 7));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        n = n % 2 == 0 ? n : n - 1;
        for (; n > 1; n = n - 2) {
            for (int i = 0; i <= s.length() - n; i++) {
                if (isValid(s, i, i + n - 1)) {
                    return n;
                }
            }
        }
        return 0;
    }

    public boolean isValid(String s, int start, int end) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(start));
        for (int i = start + 1; i <= end; i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
            } else if (s.charAt(i) == ')') {
                return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses3(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 > 0 ? dp[i - 2] : 0);
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int longestValidParentheses4(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = right = 0;
            } else if (right == left) {
                maxLen = Math.max(maxLen, left * 2);
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = right = 0;
            } else if (right == left) {
                maxLen = Math.max(maxLen, left * 2);
            }
        }
        return maxLen;
    }
}
