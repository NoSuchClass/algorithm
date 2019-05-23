package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 */
public class Code_3_2_MaxGap {
	public static int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (min == max) {
			return 0;
		}
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		
		for (int i = 0; i < len; i++) {
			int bit = bucket(min, max, len, nums[i]);
			mins[bit] = hasNum[bit] ? Math.min(mins[bit], nums[i]):nums[i];
			maxs[bit] = hasNum[bit] ? Math.max(maxs[bit], nums[i]):nums[i];
			hasNum[bit] = true;
		}
		
		int lastMax = maxs[0];
		int res = 0 ;
		for (int i = 0; i < len+1; i++) {
			if (hasNum[i]) {
				res = Math.max((mins[i] - lastMax), res);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	public static int bucket(int min, int max, int len, int num) {
		//这儿为什么要×len，而不是×（len+1）呢
		return (int)((num - min) * len / (max - min));
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {1,2,0,150,225};
//		int[] arr = new int [4];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (100*Math.random());
//			System.out.println(arr[i]);
//		}
		System.out.println("结果");
		System.out.println(maxGap(arr));
	}
}
