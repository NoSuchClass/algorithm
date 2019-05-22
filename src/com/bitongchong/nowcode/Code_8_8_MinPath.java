package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向右
 * 或者向下。沿途经过的数字要累加起来。返回最小的路径
 */
public class Code_8_8_MinPath {
	public static int minPath(int[][] arr) {
		return process(arr, 0, 0);
	}

	public static int process(int[][] matrix, int i, int j) {
		if (i == matrix.length - 1 && j == matrix[0].length - 1) {
			return matrix[i][j];
		}
		if (i == matrix.length - 1) {
			return matrix[i][j] + process(matrix, i, j + 1);
		}
		if (j == matrix[0].length -1) {
			return matrix[i][j] + process(matrix, i + 1, j);
		}
		int right = process(matrix, i, j + 1);
		int down = process(matrix, i + 1, j);
		return matrix[i][j] + Math.min(right, down);
	}

	public static void main(String[] args) {
		int[][] arr = {{3,2,1,0},{7,5,0,1},{3,7,6,2}};
		System.out.println(minPath(arr));
	}
}
