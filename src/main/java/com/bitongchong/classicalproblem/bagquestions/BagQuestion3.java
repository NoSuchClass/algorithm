package com.bitongchong.classicalproblem.bagquestions;

/**
 * @author liuyuehe
 * @description 背包问题plus：使用动态规划
 * @date 2019/11/25
 */
public class BagQuestion3 {
    /**
     * 包里能放最重物品的结果
     */
    private static int maxWeightRes = 0;
    /**
     * 包里能够装的最重重量
     */
    private static int maxWeightAvail = 9;
    /**
     * 需要装的物品重量
     */
    private static int[] goods = {1, 61, 1, 1, 1, 1, 0};
    private static boolean[][] states = new boolean[goods.length][maxWeightAvail + 1];

    private static void maxNumberWay() {
        // 初始化第一行，即初始状态
        states[0][0] = true;
        // 避免第一件物品就超出背包承重
        if (goods[0] <= maxWeightAvail) {
            states[0][goods[0]] = true;
        }
        for (int i = 1; i < goods.length; i++) {
            for(int j = 0; j <= maxWeightAvail; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j + goods[i] <= maxWeightAvail; j++) {
                if (states[i - 1][j]) {
                    states[i][j + goods[i]] = true;
                }
            }
        }
        for (int j = maxWeightAvail; j >= 0; j--) {
            if (states[goods.length - 1][j]) {
                maxWeightRes = j;
                break;
            }
        }
    }

    public static void main(String[] args) {
        BagQuestion3.maxNumberWay();
        System.out.println(maxWeightRes);
    }
}
