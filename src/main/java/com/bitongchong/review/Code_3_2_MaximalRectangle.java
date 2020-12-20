package com.bitongchong.review;

public class Code_3_2_MaximalRectangle {
    public static int maxRecSize(int[][] map) {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            int[] arr = new int[map[0].length];
            for (int j = 0; j < map[0].length; j++) {
                arr[j] = map[i][j] == 0 ? 0 : arr[j] + 1;
            }
        }
        return 0;
    }
}
