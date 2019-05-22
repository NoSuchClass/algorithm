package com.bitongchong.nowcodereview;

//时间复杂度：O(N*logN)    空间复杂度：O(logN)
//它虽然在最坏的情况下是O(N)，但实际上这个是用数学上的大样本概率期望得到的空间复杂度
//空间复杂度是用在p，也就是用在存储分界点这儿。
public class Code_09_QuickSort_Original {
	public static void sortFunc(int[] arr) {
		int L = 0;
		int R = arr.length - 1;
		quickSort(arr, L, R);
	}
	
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			int p = partition(arr, L, R);
			quickSort(arr, L, p - 1);
			quickSort(arr, p + 1, R);
		}
	}
	
	public static int partition(int[] arr, int L, int R) {
		int start = L - 1;
		int end = R;//这儿取R的原因是可以减少一个变量，让最后一个数做为比较值不参与交换，在排序完成之后才参与交换
		while(L < end) {
			if (arr[L] <= arr[R]) {
				swap(arr, L++, ++start);
			}else {
				swap(arr, L, --end);
			}
		}
		swap(arr, L, R);
		return L;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 45, 245, 0, -2145, 57, 3, 3, 3, 3, 3, 12, 43, 524, 36, 25, 625, 7 };
		sortFunc(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
