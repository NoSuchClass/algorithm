package com.bitongchong.classicalproblem;

/*
 *问题描述：
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵
 * 例如： 1 2 3 4
 * 		5 6 7 8
 * 		9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】 额外空间复杂度为O(1
 */
public class Code_4_4_ZigZagPrintMatrix {
	public static void zigZagPrintMatrix(int[][] matrix) {
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean upPrint = true;
		while(aR != endR + 1 && aC != endC + 1) {
			zigZagPrint(aR, aC, bR, bC, matrix, upPrint);
			//注意此处的判断先后顺序，因为aC的判断来源是一开始的aR，而在这里aR如果先处理的话aC就不正确了，相当于加了两次
			aC = aR == endR ? aC + 1 : aC; 
			aR = aR == endR ? aR : aR + 1;
			bR = bC == endC ? bR + 1 : bR;
			bC = bC == endC ? bC : bC + 1;
			
			upPrint = !upPrint;
		}
	}
	public static void zigZagPrint(int aR, int aC, int bR, int bC, int[][] m, boolean upPrint) {
//		if (aR == bR) {
//			System.out.println(m[aR][aC]);
//		}else {
//			if (upPrint) {
//				for (int i = 0; aR - i >= bR; i++) {
//					System.out.println(m[aR - i][aC + i]);
//				}
//			}else {
//				for (int i = 0; i + bR <= aR ; i++) {
//					System.out.println(m[bR + i][bC - i]);
//				}
//			}
//		}
		if (upPrint) {
			while(aC != bC + 1) {
				System.out.println(m[aR--][aC++]);
			}
		}else {
			while(bR != aR + 1) {
				System.out.println(m[bR++][bC--]);
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i+j*i;
			}
		}
		for (int[] is : matrix) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();
		}
		zigZagPrintMatrix(matrix);
	}
}
