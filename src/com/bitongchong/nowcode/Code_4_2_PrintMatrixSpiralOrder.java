package com.bitongchong.nowcode;

/*
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 
 * 1	2	3	4 
 * 5	6	7	8 
 * 9	10	11	12 
 * 13	14	15	16 
 * 打印结果为：
 * 1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1
 * 
 */
public class Code_4_2_PrintMatrixSpiralOrder {
	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while(dR >= tR && dC >= tC) {
			printEdge(tR++, tC++, dR--, dC--, matrix);
		}
	}
	public static void printEdge(int tR, int tC, int dR, int dC, int[][] matrix) {
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				System.out.print(matrix[tR][i]+" ");
			}
		}else if (tC == dC) {
			for (int i = tR; i <= dR; i++) {
				System.out.print(matrix[i][tC]+" ");
			}
		}else {
			int curC = tC;
			int curR = tR;
			while(curC != dC) {
				System.out.print(matrix[curR][curC]+" ");
				curC++;
			}
			while(curR != dR) {
				System.out.print(matrix[curR][curC]+" ");
				curR++;
			}
			while(curC != tC) {
				System.out.print(matrix[curR][curC]+" ");
				curC--;
			}
			while(curR != tR) {
				System.out.print(matrix[curR][curC]+" ");
				curR--;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[6][4];
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
		spiralOrderPrint(matrix);
	}
}
