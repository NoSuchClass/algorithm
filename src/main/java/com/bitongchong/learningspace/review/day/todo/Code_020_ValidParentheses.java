package com.bitongchong.learningspace.review.day.todo;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/6 22:46
 */
public class Code_020_ValidParentheses {
    // 这个方法虽然说也是正确方法，但是实际上耗时却会非常长，因为是对每一个元素都进行了遍历，而实际上譬如 "}()()()()()..."
    // 这样子的字符串，其实从一开始能够得出false的答案，又或者 "{{{{{(}}}}}" 这种，只要发现是右方符号的值，并且与当前
    // 栈顶的元素不匹配，则可以确定为false
    public boolean isValidWrong(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Character> regMap = new HashMap<>(4);
        regMap.put('[', ']');
        regMap.put('{', '}');
        regMap.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.size() == 0) {
                stack.add(c);
            } else {
                if (regMap.get(stack.peek()) != null && c == regMap.get(stack.peek())) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidTrue(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> regMap = new HashMap<>(4);
        regMap.put(']', '[');
        regMap.put('}', '{');
        regMap.put(')', '(');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Character character = regMap.get(c);
            if (character != null) {
                if (stack.isEmpty() || !character.equals(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        new Code_020_ValidParentheses().isValidWrong("([)]");
    }
}
