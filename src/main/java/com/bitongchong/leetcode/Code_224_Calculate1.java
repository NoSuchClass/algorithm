package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2019/11/6 8:22
 */
public class Code_224_Calculate1 {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int index = 0;
        Stack<Integer> stack = new Stack();
        char[] arr = s.toCharArray();
        while (index < s.length()) {
            if (' ' == arr[index]) {
                index++;
            } else if ('+' == arr[index]) {
                sign = 1;
                index++;
            } else if ('-' == arr[index]) {
                sign = -1;
                index++;
            } else if (Character.isDigit(arr[index])) {
                int temp = 0;
                while (index < s.length() && Character.isDigit(arr[index])) {
                    temp = temp * 10 + Character.getNumericValue(arr[index]);
                    index++;
                }
                res += sign * temp;
            } else if ('(' == arr[index]) {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                index++;
            } else if (')' == arr[index]) {
                res = res * stack.pop() + stack.pop();
                index++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new Code_224_Calculate1().calculate("1-(5)"));
    }
}
