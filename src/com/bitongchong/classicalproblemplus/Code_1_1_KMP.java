package com.bitongchong.classicalproblemplus;

/**问题描述
 * 输入两个字符串，寻找第一个字符串中是否有与第二个字符串相同的子串
 * 如果有，返回子串的第一个字符下标，否则返回-1
 * 
 */
public class Code_1_1_KMP {
    public static int getIndexOf(String s1, String str2) {
        if (s1 == null || str2 == null || s1.length() < 1
                || str2.length() < 1) {
            return -1;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(chars2);
        while (i1 < chars1.length && i2 < chars2.length) {
            if (chars1[i1] == chars2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == chars2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) return new int[]{-1};
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args){
        System.out.println(getIndexOf("eeelijunzhe12", "lijunzhe1"));
    }
}
