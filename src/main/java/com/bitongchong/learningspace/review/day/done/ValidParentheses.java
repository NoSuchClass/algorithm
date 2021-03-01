package com.bitongchong.learningspace.review.day.done;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/9 8:44
 */
public class ValidParentheses {
    public static boolean valid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 如果符号序列长度为奇数，那么一定有一个符号不能匹配上，则返回false
        if (s.length() % 2 != 0) {
            return false;
        }
        // 我们可以将符号类型分为左符号（'{','[','('）和右符号（'}',']',')'），实际上一个符号入栈只可能有两种情况，
        // 一种是左符号入栈，一种是右符号入栈。
        // 如果是左符号入栈，实际上是可以直接入栈的，因为只通过左符号还不能知道后续是否还会存在满足匹配关系的右符号
        // 入栈。
        // 如果是右符号入栈，则需要进行校验。校验规则是：判断离ta最近的一个符号是否为与之匹配的左符号，匹配则将栈顶
        // 元素pop出来，代表符号已经被匹配上了，如果不匹配，则直接返回false，代表匹配失败。（如果栈顶为空，并且入
        // 栈的是右符号，也是直接返回匹配失败的）
        Map<Character, Character> mapper = new HashMap<>(4);
        mapper.put('}', '{');
        mapper.put(']', '[');
        mapper.put(')', '(');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (mapper.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(mapper.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
