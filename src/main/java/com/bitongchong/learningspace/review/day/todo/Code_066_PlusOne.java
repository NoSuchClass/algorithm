package com.bitongchong.learningspace.review.day.todo;

/**
 * @author liuyuehe
 * @date 2021/1/4 23:04
 */
public class Code_066_PlusOne {
    public int[] plusOne(int[] digits) {
        // 正常情况下，如果有进位一定是9 -> 10这种情况，那么一定对10取余为0，则继续循环plus one
        // 如果未进位，那么即表明该位不存在进位，可以直接返回处理完成的数组
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 每一位都进一位的情况，则只可能是99 9999 这种情况，即最后一位如果都还有进位的话，
        // 那么一定是100 10000 这种第一位为1，后面都为0的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
