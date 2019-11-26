package com.bitongchong.classicalproblem.bagquestions;

/**
 * @author liuyuehe
 * @description 背包问题simple_plus：加入备忘录
 * @date 2019/11/25
 */
public class BagQuestion2 {
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
    /**
     * “备忘录”：记录递归树曾经计算过的中间过程
     */
    private static boolean[][] memory = new boolean[goods.length][maxWeightAvail];

    private static void maxNumberWay(int i, int curMaxWeight) {
        // i == goods.length：代表已经将所有物品装完，curMaxWeight == maxWeightAvail：代表已到达最大承重
        if (i == goods.length || curMaxWeight == maxWeightAvail) {
            maxWeightRes = Math.max(maxWeightRes, curMaxWeight);
            return;
        }
        // 如果在备忘录中计算过，则直接return，因为计算结果肯定已经与maxWeightRes相比较过了
        if (memory[i][curMaxWeight]) {
            return;
        }
        // 在备忘录中记录下当前状态，代表已经记录过（只有一个状态所有的计算都结束，才会被下一次计算读取）
        memory[i][curMaxWeight] = true;
        // 因为遇到一个物品总共有两种选择：1、不装第i个物品
        maxNumberWay(i + 1, curMaxWeight);
        ///2、如果装下这个物品不会到达最大承重，那么装第i个物品
        if (curMaxWeight + goods[i] <= maxWeightAvail) {
            maxNumberWay(i + 1, curMaxWeight + goods[i]);
        }
    }

    public static void main(String[] args) {
        BagQuestion2.maxNumberWay(0, 0);
        System.out.println(maxWeightRes);
    }
}
