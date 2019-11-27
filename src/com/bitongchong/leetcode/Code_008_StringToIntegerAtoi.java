package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 字符串转换整数 (atoi)
 * @date 2019/11/27
 */
public class Code_008_StringToIntegerAtoi {
    public int myAtoi(String str) {
        boolean flag = true;
        int start = 0;
        int returnRes = 0;
        StringBuilder stringBuilder = new StringBuilder(str.length());
        char[] chars = str.toCharArray();
        if ("".equals(str)) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if ('-' == chars[i] || '+' == chars[i] || Character.isDigit(chars[i])) {
                if ('-' == chars[i]) {
                    flag = false;
                }
                if (Character.isDigit(chars[i]) && Integer.parseInt(String.valueOf(chars[i])) != 0) {
                    stringBuilder.append(chars[i]);
                }
                start = i;
                break;
            } else if (' ' != chars[i]) {
                return 0;
            }
        }
        while (start + 1 < str.length() && Character.isDigit(chars[start + 1])) {
            start++;
            if (!(stringBuilder.toString().isEmpty() && Integer.parseInt(String.valueOf(chars[start])) == 0)) {
                stringBuilder.append(chars[start]);
            }
        }
        if ("".equals(stringBuilder.toString())) {
            return 0;
        }
        String res = stringBuilder.toString();
        if (res.length() < String.valueOf(Integer.MAX_VALUE).length()) {
            returnRes = flag ? Integer.parseInt(res) : -Integer.parseInt(res);
        } else if (res.length() > String.valueOf(Integer.MAX_VALUE).length()) {
            returnRes = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            try {
                returnRes = flag ? (int) Integer.valueOf(res) : -(int) Integer.valueOf(res);
            } catch (Exception e) {
                returnRes = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return returnRes;
    }


  /*  public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        long res = 0;
        boolean isNegative = str.charAt(0) == '-';
        if (isNegative || str.charAt(0) == '+') {
            str = str.substring(1);
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                break;
            }
            res = res * 10 + (c - '0');
            if (res > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        if (isNegative) {
            res *= -1;
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) res;
    }
    */

    public static void main(String[] args) {
        System.out.println(new Code_008_StringToIntegerAtoi().myAtoi("-2147483648"));
    }
}
