package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)
 */
public class Code_4_3_SquareRotate {
	public static void rotate(int[][] matrix) {
		int dR = matrix.length - 1;
		int dC = matrix.length - 1;
		int tC = 0;
		int tR = 0;
		while(tR < dR) {
			rotateEdge(dC--, dR--, tC++, tR++, matrix);
		}
	}
	public static void rotateEdge(int dC, int dR, int tC, int tR, int[][] m) {
//		int curC = tC;
//		int curR = tR;
//		int curC1 = dC;
//		int curR1 = dR;
//		int temp = 0;
//		int temp2 = 0;
//		while(curC<dC && curR<dR && curC1>tC && curR1>tR) {
//			temp = matrix[curR][dC];
//			matrix[curR][dC] = matrix[tR][curC];
//			temp2 = matrix[dR][curC1];
//			matrix[dR][curC1] = temp;
//			matrix[tR][curC] = matrix[curR1][tC];
//			matrix[curR1][tC] = temp2;
//			curC++;
//			curR++;
//			curC1--;
//			curR1--;
//		}
		int times = dC - tC;
		int tmp = 0;
		for (int i = 0; i < times; i++) {
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i ][dC];
			m[tR + i ][dC] = tmp;
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i+j;
			}
		}
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();
		}
		rotate(matrix);
		System.out.println();
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();
		}
	}
}
