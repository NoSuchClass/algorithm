package com.bitongchong.classicalproblem;


/*
 * 岛问题一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 * 
 * 举例：	0 0 1 0 1 0
 *      1 1 1 0 1 0
 *      1 0 0 1 0 0
 *      0 0 0 0 0 0
 *      这个矩阵中有三个
 */
public class Code_7_2_IsLands {
	public static int findLands(int[][] arr) {
		int res = 0;
		int m = arr.length;
		int n = arr[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					res++;
					injection(arr, i, j);
				}
			}
		}
		return res;
	}
	
	public static void injection(int[][] arr, int i, int j) {
		if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 2;
		injection(arr, i + 1, j);
		injection(arr, i - 1, j);
		injection(arr, i, j + 1);
		injection(arr, i, j - 1);
	}
	
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(findLands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 1, 0, 1, 0, 1, 1, 1, 0, 0 },
						{ 0, 1, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(findLands(m2));

	}
}
