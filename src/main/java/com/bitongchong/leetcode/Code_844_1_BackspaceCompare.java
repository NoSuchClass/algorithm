package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2019/10/30 22:26
 */
public class Code_844_1_BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder stringBuilderS = new StringBuilder();
        StringBuilder stringBuilderT = new StringBuilder();
        int countS = 0;
        int countT = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '#') {
                countS ++;
                continue;
            }
            if (countS != 0) {
                countS--;
                continue;
            }
            if (S.charAt(i) != '#') {
                stringBuilderS.append(S.charAt(i));
            }
        }
        for (int j = T.length() - 1; j >= 0; j--) {
            if (T.charAt(j) == '#') {
                countT ++;
                continue;
            }
            if (countT != 0) {
                countT--;
                continue;
            }
            if (T.charAt(j) != '#') {
                stringBuilderT.append(T.charAt(j));
            }
        }
        return stringBuilderS.toString().equals(stringBuilderT.toString());
    }

    public static void main(String[] args) {
        Code_844_1_BackspaceCompare code_844_backspaceCompare = new Code_844_1_BackspaceCompare();
        boolean b = code_844_backspaceCompare.backspaceCompare("b#a#c#b", "b");

        System.out.println(b);

    }
}
