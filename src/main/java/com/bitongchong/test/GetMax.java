package com.bitongchong.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GetMax {
    public static void main(String[] args) {
        System.out.println("input the size of score:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("input how many socre you want:");
        int getHowManyNum = sc.nextInt();
        System.out.println("input your socer");
        ArrayList<Integer> inputArr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            inputArr.add(sc.nextInt());
        }
        Collections.sort(inputArr);
        System.out.println("the result is:");
        for (int i = inputArr.size() - 1; i >= 0 && getHowManyNum > 0; i--, getHowManyNum--) {
            System.out.print(inputArr.get(i) + " ");
        }
    }
}