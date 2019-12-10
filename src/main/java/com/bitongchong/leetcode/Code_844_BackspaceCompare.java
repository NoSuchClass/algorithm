package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2019/10/30 21:14
 */
public class Code_844_BackspaceCompare {
    public static void main(String[] args) {
        Code_844_BackspaceCompare code_844_backspaceCompare = new Code_844_BackspaceCompare();
        boolean b = code_844_backspaceCompare.backspaceCompare("b#a#c#b", "b");
        System.out.println(b);

    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<Character>();
        Stack<Character> stackT = new Stack<Character>();
        int i = 0;
        int j = 0;
        for (char s : S.toCharArray()) {
            if (s != '#') {
                stackS.push(s);
            }
            if (!stackS.isEmpty() && s == '#') {
                stackS.pop();
            }
        }
        for (char t : T.toCharArray()) {
            if (t != '#') {
                stackT.push(t);
            }
            if (!stackT.isEmpty() && t == '#') {
                stackT.pop();
            }
        }
        return stackS.equals(stackT);
    }
}
