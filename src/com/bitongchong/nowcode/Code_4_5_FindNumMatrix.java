package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。 
 * 例如： 	0 1 2 5
 * 			2 3 4 7
 * 			4 4 4 8
 * 			5 7 7 9 
 * 如果K为7，返回true；如果K为6，返回false。
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)
 */
public class Code_4_5_FindNumMatrix {
	public static Boolean find(int[][] matrix, int num) {
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		int tR = 0;
		int tC = endC;
		boolean res = false;
		while(tR>=0&&tR<=endR&&tC>=0&&tC<=endC) {			
			if(num < matrix[tR][tC]) {
				tC--;
			}
			if(num == matrix[tR][tC]) {
				res = true;
				break;
			}
			if(num > matrix[tR][tC]) {
				tR++;
			}
		}			
		return res;
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
		System.out.println(find(matrix, 9));;
	}
}
