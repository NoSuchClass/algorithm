package com.bitongchong.nowcodereview;

public class Code_12_HeapSort_GetMedian {

	public static class MidHeap {
		private int[] bigHeap;
		private int[] smallHeap;
		private int bigHeapSize = -1;
		private int smallHeapSize = -1;

		public void insert(int num) {
			if (num <= bigHeap[0]) {
				insertBigHeap(bigHeap, num, bigHeapSize++);
				if (Math.abs(smallHeapSize - bigHeapSize) > 2) {
					swap(bigHeap, 0, bigHeapSize--);
					insertSmallHeap(smallHeap, bigHeap[0], smallHeapSize++);
					bigHeap[0] = 0;
					heapify(bigHeap, 0, bigHeapSize);
				}
			} else {
				insertSmallHeap(smallHeap, num, smallHeapSize++);
				if (Math.abs(smallHeapSize - bigHeapSize) > 2) {
					swap(smallHeap, 0, smallHeapSize);
					smallHeapSize--;
					insertBigHeap(bigHeap, smallHeap[0], bigHeapSize++);
					smallHeap[0] = 0;
					heapify(smallHeap, 0, smallHeapSize);
				}
			}
		}

		private void insertBigHeap(int[] arr, int num, int heapSize) {
			arr[heapSize + 1] = num;
			while (arr[(heapSize) / 2] < arr[heapSize + 1]) {
				swap(arr, heapSize + 1, heapSize);
			}
		}

		private void insertSmallHeap(int[] arr, int num, int heapSize) {
			arr[heapSize + 1] = num;
			while (arr[(heapSize) / 2] > arr[heapSize + 1]) {
				swap(arr, heapSize + 1, heapSize);
			}
		}

		public int getMid() {
			if (bigHeapSize == smallHeapSize) {
				return (bigHeap[0] + smallHeap[0]);
			} else if (bigHeapSize > smallHeapSize) {
				return bigHeap[0];
			} else {
				return smallHeap[0];
			}
		}

		private void heapify(int[] heap, int index, int heapSize) {
			int left = 2 * index + 1;
			while (left <= heapSize) {
				int bigest = (left + 1) <= heapSize && heap[left] < heap[(left + 1)] ? (left + 1) : left;
				bigest = heap[bigest] > heap[index] ? bigest : index;
				if (bigest == index) {
					break;
				}
				swap(heap, index, bigest);
				index = bigest;
				left = 2 * index + 1;
			}
		}

		public MidHeap(int[] arr) {
			super();
			bigHeap = new int[arr.length];
			smallHeap = new int[arr.length];
		}

		public void swap(int[] arr, int a, int b) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 5, 6, 56, 5, 7, 0,1,7,4,57,34764,3,346,23,234,34,23452,332 };
		MidHeap midHeap = new MidHeap(arr);
		for (int i = 0; i < arr.length; i++) {
			midHeap.insert(arr[i]);
		}
		System.out.println(midHeap.getMid());
	}
}
