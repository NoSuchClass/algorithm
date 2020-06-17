package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/6/17 11:01
 */
public class Code_1014_BestSightseeingPair {
    public static void main(String[] args) {
        System.out.println(new Code_1014_BestSightseeingPair().maxScoreSightseeingPair(new int[]{8,1,59,2,6}));
    }

    /**
     * 这道题主要是需要判断题目中给出需要求的值，受到哪些东西影响，哪些部分的值实际上是不会改变的，哪些值是会改变的，找出来就存储那些
     * 不会改变的值，把注意力集中在那些会改变的值上面。这道题里面，题目给出所求的值是：A[i] + A[j] + i - j（i < j），虽然看上去 i
     * 和 j 都是可以变化的值，但是实际上可以将所求的值分为两个部分 A[i] + i 和 A[j] - j 的和，由于在遍历的时候，因为 i < j，所以
     * 先能够确定 A[j] - j 的值，然后在 [0, j - 1]这个范围内找出最大的 A[i] + i 的值即可。
     * 所以在遍历的时候，使用一个值去存储[0, j - 1]这个范围内的最大 A[i] + i 的值就能将这道题从O(n^2)化简到O(n)
     * @param A -
     * @return -
     */
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int maxI = 0;
        for (int j = 0; j < A.length; j++) {
            maxScore = Math.max(A[j] - j + maxI, maxScore);
            maxI = Math.max(A[j] + j, maxI);
        }
        return maxScore;
    }
}
