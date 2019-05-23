package com.bitongchong.leetcode;

import java.util.HashMap;

public class Code_149_MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points.length < 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int m = 1;  // 重合
            int n = 0;  // 垂直
            Point a = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                Point b = points[j];
                if (a.x == b.x) {
                    if (a.y == b.y) m++;
                    else n++;
                } else {
                    double slope = (double) (a.y - b.y) / (double) (a.x - b.x);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
            int max = n;
            for (Double key :
                    map.keySet()) {
                max = max > map.get(key) ? max : map.get(key);
            }
            res = Math.max(res, max + m);
        }
        return res;
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
