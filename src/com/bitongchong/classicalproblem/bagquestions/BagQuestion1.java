package com.bitongchong.classicalproblem.bagquestions;

/**
 * @author liuyuehe
 * @description 背包问题simple：通过回溯来解决
 * 问题描述：
 * 有一堆物品，物品有自身的重量，现在有一个标有最大负重的背包，请计算出能够放入的最大重量
 * @date 2019/11/25
 */
public class BagQuestion1 {
    /**
     * 包里能放最重物品的结果
     */
    private static int maxWeightRes = 0;
    /**
     * 需要装的物品重量
     */
    private static int[] goods = {1, 61, 1, 1, 1, 1, 0};

    private static void maxNumberWay(int i, int curMaxWeight) {
        // i == goods.length：代表已经将所有物品装完，curMaxWeight == maxWeightAvail：代表已到达最大承重
        // 包里能够装的最重重量
        int maxWeightAvail = 9;
        if (i == goods.length || curMaxWeight == maxWeightAvail) {
            maxWeightRes = Math.max(maxWeightRes, curMaxWeight);
            return;
        }
        // 因为遇到一个物品总共有两种选择：1、不装第i个物品
        maxNumberWay(i + 1, curMaxWeight);
        ///2、如果装下这个物品不会到达最大承重，那么装第i个物品
        if (curMaxWeight + goods[i] <= maxWeightAvail) {
            maxNumberWay(i + 1, curMaxWeight + goods[i]);
        }
    }

    public static void main(String[] args) {
        BagQuestion1.maxNumberWay(0, 0);
        System.out.println(maxWeightRes);
    }
}
