package com.bitongchong.codinginterviews;

import java.util.ArrayList;

/*
 * 问题描述：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
	// 自己的方法，开辟的数组多，时间n
	public static int[] func(int[] array) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			@SuppressWarnings("unused")
			boolean a = array[i] % 2 == 0 ? arrayList.add(array[i]) : arrayList2.add(array[i]);
		}
		arrayList2.addAll(arrayList);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayList2.get(i);
		}
		return  array;
	}
	
	public static void func2(int[] array) {
		if (array == null) {
			return;
		}
		int[] res = new int[array.length];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				res[count++] = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				res[count++] = array[i];
			}
		}
		for (int i = 0; i < res.length; i++) {
			array[i] = res[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
//		arr = func(arr);
		func2(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}
}
