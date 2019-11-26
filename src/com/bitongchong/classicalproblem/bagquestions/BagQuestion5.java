package com.bitongchong.classicalproblem.bagquestions;

/**
 * @author liuyuehe
 * @description 背包问题：引入物品价值
 * 问题描述：
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 * @date 2019/11/26
 */
public class BagQuestion5 {
    private static int maxValueRes = 0;
    private static int[] items = {1, 61, 1, 1, 1, 1, 0};
    private static int[] value = {100, 32, 2, 1, 1, 1, 0};

    private static void func(int index, int curWeight, int curValue) {
        int maxWeightAvail = 9;
        if (index == items.length || curWeight == maxWeightAvail) {
            maxValueRes = Math.max(curValue, maxValueRes);
            return;
        }
        func(index + 1, curWeight, curValue);
        if (curWeight + items[index] <= maxWeightAvail) {
            func(index + 1, curWeight + items[index], curValue + value[index]);
        }
    }

    public static void main(String[] args) {
        BagQuestion5.func(0, 0, 0);
        System.out.println(maxValueRes);
    }
}
