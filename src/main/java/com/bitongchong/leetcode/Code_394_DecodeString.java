package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/5/28 8:35
 */
public class Code_394_DecodeString {

    int index;

    public static void main(String[] args) {
        System.out.println(new Code_394_DecodeString().decodeString2("3[a2[c]]"));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int flag = 0;
                int start = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == '[') {
                        count = Integer.parseInt(s.substring(i, j));
                        start = j;
                        break;
                    }
                }
                for (int j = start + 1; j < arr.length; j++) {
                    if (arr[j] == '[') {
                        flag++;
                    } else if (arr[j] == ']') {
                        if (flag == 0) {
                            String process = decodeString(s.substring(start + 1, j));
                            for (int k = 0; k < count; k++) {
                                res.append(process);
                            }
                            i = j;
                        } else {
                            flag--;
                        }
                    }
                }
            } else if (arr[i] != ']') {
                res.append(arr[i]);
                index++;
            }
        }
        return res.toString();
    }

    public String decodeString2(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                String letter = getLetter(s);
                stack.push(letter);
            } else if (Character.isDigit(c)) {
                String digit = getDigit(s);
                stack.push(digit);
            } else if (c == '[') {
                stack.push(String.valueOf(c));
                index++;
            } else if (c == ']') {
                String token = getToken(stack);
                stack.push(token);
            }
        }
        for (String s1 : stack) {
            res.append(s1);
        }
        return res.toString();
    }

    private String getToken(Stack<String> queue) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder letter = new StringBuilder(queue.pop());
        while (!"[".equals(queue.peek())) {
            letter.insert(0, queue.pop());
        }
        queue.pop();
        int digit = Integer.parseInt(queue.pop());
        for (int i = 0; i < digit; i++) {
            stringBuilder.append(letter);
        }
        index++;
        return stringBuilder.toString();
    }

    private String getLetter(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                stringBuilder.append(c);
                index++;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    private String getDigit(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
                index++;
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
