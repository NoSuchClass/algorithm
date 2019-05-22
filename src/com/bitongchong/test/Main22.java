package com.bitongchong.test;

public class Main22 {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] p = patition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    public static int[] patition(int[] arr, int n, int m) {
        int left = n - 1;
        int right = m;
        while (n < right) {
            if (arr[n] < arr[m]) {
                swap(arr, n++, ++left);
            } else if (arr[n] > arr[m]) {
                swap(arr, n, --right);
            } else {
                n++;
            }
        }
        swap(arr, right, m);
        return new int[] { left + 1, right };
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {11,2,5,6,115,18,1,96,-2,0};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
