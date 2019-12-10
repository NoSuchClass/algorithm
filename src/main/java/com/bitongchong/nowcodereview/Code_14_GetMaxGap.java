package com.bitongchong.nowcodereview;

public class Code_14_GetMaxGap {
	static class Bucket {
		public int max;
		public int min;
		public boolean flag;

		public Bucket() {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			flag = false;
		}
	}

	public static void getMaxGap(int[] arr) {
		int maxNum = arr[0];
		int minNum = arr[0];
		for(int i = 0; i < arr.length; i++) {
			maxNum = maxNum >= arr[i] ? maxNum : arr[i];
			minNum = minNum <= arr[i] ? minNum : arr[i];
		}
		Bucket[] buckets = new Bucket[arr.length + 1];
		int bucketGap = (maxNum - minNum) / (arr.length + 1);
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i] / (bucketGap + 1);
			buckets[num].flag = true;
			buckets[num].max = buckets[num].max > arr[i] ? buckets[num].max : arr[i];
			buckets[num].min = buckets[num].min < arr[i] ? buckets[num].min : arr[i];
		}
		System.out.println("over");
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,4,16,60,30};
		getMaxGap(arr);
	}
}
