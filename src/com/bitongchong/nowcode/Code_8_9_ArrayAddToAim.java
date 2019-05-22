package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，能
 * 不能累加得到aim，返回true或者fal
 */
public class Code_8_9_ArrayAddToAim {
	public static boolean arrayAdd(int aim, int[] arr) {
		int res = 0;
		int i = 0;
		return process(aim, arr, res, i);
	}

	public static boolean process(int aim, int[] arr, int res, int i) {
		//一定要分清什么时候才是终止条件
		if (i == arr.length) {
			return res == aim;
		}
		return process(aim, arr, res + arr[i], i + 1) || process(aim, arr, res, i + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6 };
		int aim = 0;
		System.out.println(arrayAdd(aim, arr));
	}
}