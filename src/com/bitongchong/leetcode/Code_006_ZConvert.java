package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description Z 字形变换 ： 像类似的题，大致上有两个状态，其中一个状态依赖另一个状态，那么可以使用一个状态标识符
 * @date 2019/11/27
 */
public class Code_006_ZConvert {
    public String convert(String s, int numRows) {
        if (s == null || "".equals(s) || numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s.length());
        char[][] resMap = new char[numRows][s.length()];
        char[] element = s.toCharArray();
        boolean flag = true;
        int m = 0;
        int n = 0;
        for (char c : element) {
            if (flag && m < numRows) {
                resMap[m][n] = c;
                m++;
                if (m == numRows) {
                    flag = false;
                    m--;
                }
            } else if (!flag) {
                m--;
                n++;
                resMap[m][n] = c;
                if (m == 0) {
                    flag = true;
                    m++;
                }
            }
        }
        for (char[] chars : resMap) {
            for (char c : chars) {
                if ('\u0000' == c) {
                    continue;
                }
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String convert = new Code_006_ZConvert().convert(s, numRows);
        System.out.println(convert);
    }
}
