package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * 题目描述
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class Code_150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<Long>();
        Long res = new Long(0);
        Long m = new Long(0), n = new Long(0);
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                if (tokens[i].equals("+")) {
                    m = stack.pop();
                    n = stack.pop();
                    res = n + m;
                    stack.push(res);
                } else if (tokens[i].equals("-")) {
                    m = stack.pop();
                    n = stack.pop();
                    res = n - m;
                    stack.push(res);
                } else if (tokens[i].equals("*")) {
                    m = stack.pop();
                    n = stack.pop();
                    res = n * m;
                    stack.push(res);
                } else if (tokens[i].equals("/")) {
                    m = stack.pop();
                    n = stack.pop();
                    res = n / m;
                    stack.push(res);
                }
            } else {
                stack.push(Long.valueOf(tokens[i]));

            }
        }
        return stack.pop().intValue();
    }
}
