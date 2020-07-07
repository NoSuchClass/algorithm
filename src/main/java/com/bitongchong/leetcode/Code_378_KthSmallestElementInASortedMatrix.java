package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/7/2 7:53
 */
public class Code_378_KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        System.out.println(new Code_378_KthSmallestElementInASortedMatrix().kthSmallest(new int[][]{{1, 5, 9},
                {10, 11, 13}, {12, 13, 15}}, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            // 为什么使用二分查找出来的left一定存在于matrix数组中？ 首先思考一下，满足在matrix数组中第k大的值会不会存在多个
            // （即多个不同的值？） 如果满足题意的结果值只能是一个相同的数，那么如果二分查找找出的数不存在与matrix中，那么必
            // 然会与matrix中的第k大的这个数存在大小关系
            //
            //如果二分查找结果 > matrix数组中第k大的数
            //如果二分查找结果 < matrix数组中第k大的数
            //
            //上面两种情况均不满足题意
            //所以二分查找结果一定存在于matrix数组中
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
