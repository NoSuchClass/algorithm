package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/14 21:36
 */
public class Code_887_SuperEggDrop {
    public int eggDrop(int totalEggs, int totalFloors) {
        int[][] cache = new int[totalEggs + 1][totalFloors + 1];

        for (int eggs = 1; eggs <= totalEggs; eggs++) {
            cache[eggs][1] = 1;
        }

        for (int floor = 1; floor <= totalFloors; floor++) {
            cache[1][floor] = floor;
        }

        for (int eggs = 2; eggs <= totalEggs; eggs++) {
            for (int floor = 2; floor <= totalFloors; floor++) {
                int max = 0;
                int lowFloor = 1;
                int highFloor = floor;
                while(lowFloor <= highFloor) {
                    int midFloor = (lowFloor + highFloor) / 2;
                    int inc = cache[eggs - 1][midFloor - 1] + 1;
                    int des = cache[eggs][floor - midFloor] + 1;
                    max = Math.max(inc, des);
                    if (inc == des) {
                        break;
                    } else if (inc > des) {
                        highFloor = midFloor - 1;
                    } else {
                        lowFloor = midFloor + 1;
                    }
                }
                cache[eggs][floor] = max;
            }
        }
        return cache[totalEggs][totalFloors];
    }
}
