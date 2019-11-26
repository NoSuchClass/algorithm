package com.bitongchong.classicalproblem.bagquestions;

/**
 * @author liuyuehe
 * @description 背包问题：动态规划的优化
 * @date 2019/11/26
 */
public class BagQuestion4 {
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
    private static boolean[] states = new boolean[maxWeightAvail + 1];

    private static void maxNumberWay() {
        states[0] = true;
        // 避免第一件物品就超出背包承重
        if (goods[0] <= maxWeightAvail) {
            states[goods[0]] = true;
        }
        for (int i = 1; i < goods.length; i++) {
            // 注：j 需要从大到小来处理，如果我们按照 j 从小到大处理的话，会出现 for 循环重复计算的问题
            for (int j = maxWeightAvail - goods[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + goods[i]] = true;
                }
            }
        }
        for (int j = maxWeightAvail; j >= 0; j--) {
            if (states[j]) {
                maxWeightRes = j;
                break;
            }
        }
    }

    public static void main(String[] args) {
        BagQuestion4.maxNumberWay();
        System.out.println(maxWeightRes);
    }
}
