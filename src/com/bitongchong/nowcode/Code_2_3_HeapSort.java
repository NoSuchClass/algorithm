package com.bitongchong.nowcode;

/*
 * 实现堆排序
 */
public class Code_2_3_HeapSort {
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int heapsize = arr.length - 1;
		while (heapsize > 0) {
			swap(arr, 0, heapsize--);
			heapify(arr, 0, heapsize);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	// 这个函数的作用是：如果完全二叉树中的其中一个数值变小了，这个函数就能够将这个变小的数沉下去
	public static void heapify(int[] arr, int index, int heapsize) {
		// 移位运算的优先级比加减乘除都要低
		int leftNode = (index << 1) + 1;
		while (leftNode <= heapsize) {
			int bigest = leftNode + 1 <= heapsize && arr[leftNode] < arr[leftNode + 1] ? leftNode + 1 : leftNode;
			bigest = arr[index] < arr[bigest] ? bigest : index;
			if (index == bigest) {
				break;
			}
			swap(arr, index, bigest);
			index = bigest;
			leftNode = (index << 1) + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] generateRandomArray(int size, int value) {
		int[] arr = new int[(int) ((size+1)*Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((int) (value*Math.random()))-(int)(value*Math.random());
		}
		return arr;
	}
	//实现拷贝数组
	public static int[] copyArray(int[] arr) {
		int[] copyArry = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copyArry[i] = arr[i];
		}
		return copyArry;
	}
	
	public static void printArr(int[] arr) {
		System.out.println(arr);
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}
/*	public static void main(String[] args) {
		for(int i2 = 0; i2 < 20; i2++) {
			int[] arr = generateRandomArray(10000, 343);
			int[] generateArr = copyArray(arr);
//			printArr(arr);
//			printArr(generateArr);
			boolean msg = true;
			heapSort(arr);
			Code_1_1_BubbleSort.bubbleSort1(generateArr);
			//因为只有String才重写了equal方法，所以不能直接使用数组的equal方法来判断两个数组是否相等
			for (int i = 0; i<arr.length; i++) {
				if (arr[i] != generateArr[i]) {
					msg = false;
				}else {
				}
			}
			System.out.println(msg?"success AC":"error");
		}
	}*/
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 4, 8, 77, -12 };
		heapSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
