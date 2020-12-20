package com.bitongchong.review;

import java.util.Scanner;

public class Solution {
    static int[] arr1 = new int[10];
    static int[] arr2 = new int[10];
    static int total;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        total = scanner.nextInt();
        int n = scanner.nextInt();
        arr1[1] = 1;
        for (int i = 2; i <= n; i++) arr1[i] = scanner.nextInt();
        System.out.println(func(n));
    }

    private static int func(int n) {
        for (int i = 1; i <= total; i++) {
            int temp = Integer.MAX_VALUE;
            int j = 1;
            while (j <= n && i >= arr1[j]) {
                temp = Math.min(arr2[i - arr1[j]], temp);
                j++;
            }
            arr2[i] = temp + 1;
        }
        return arr2[total];
    }
}
