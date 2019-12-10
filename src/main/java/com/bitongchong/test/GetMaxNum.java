package com.bitongchong.test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class GetMaxNum {
    public static int[] getFunc(int[] arr, int num) {
        int[] res = new int[num];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < num; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入成绩数组长度:");
        int n = sc.nextInt();
        System.out.println("输入需要取平均值最大的数的" +
                "个数:");
        int num = sc.nextInt();
        System.out.println("请输入你的成绩数组：");
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
        }
        int[] func = getFunc(inputArr, num);
        System.out.println("结果是:");
        for (int i :
                func) {
            System.out.println(i);
        }
    }
}
