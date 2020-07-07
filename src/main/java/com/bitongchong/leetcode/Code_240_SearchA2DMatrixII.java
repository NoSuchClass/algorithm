package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/7/2 8:32
 */
public class Code_240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            }
        }
        return false;
    }
}
