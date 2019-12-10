package com.bitongchong.classicalproblem;

//插入排序
public class Code_1_3_InsertSort {
	public static void insertSort(int[] arr) {
		//结题思路：像对扑克牌进行排序一样，对数组进行一次循环，将每一个值与它前一个值进行比对，如果比它小，就交换位置
		//同时再与前一个数字进行比较，重复这个过程
		//先找一个i，然后找一个比i大一位的数，与之比较，所以注意下它的范围
		for(int i = 1; i < arr.length; i++) {
			for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j + 1, j);
			}
		}
	}
	//生成一个对数器：首先写一个随机数组，再将数组拷贝一份，一份交给一个时
	//间复杂度可能很高的算法来计算，然后对比两个数组是否相同，一份交给自己写的算法来实现
	//size是数组的最大长度，value是值的大小范围
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
	
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}
	
	public static void printArr(int[] arr) {
		System.out.println(arr);
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}
	public static void main(String[] args) {
		int[] arr = generateRandomArray(1000, 343);
		int[] generateArr = copyArray(arr);
//		printArr(arr);
//		printArr(generateArr);
		boolean msg = true;
		insertSort(arr);
		Code_1_1_BubbleSort.bubbleSort1(generateArr);
		//因为只有String才重写了equal方法，所以不能直接使用数组的equal方法来判断两个数组是否相等
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] != generateArr[i]) {
				msg = false;
			}else {
				System.out.println(msg+":"+arr[i]);
			}
		}
		System.out.println(msg?"success AC":"error");
	}
}
