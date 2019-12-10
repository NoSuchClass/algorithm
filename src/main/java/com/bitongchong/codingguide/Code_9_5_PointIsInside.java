package com.bitongchong.codingguide;

/**
 * 题目描述：
 * 在一个二维坐标系中，所有的值都是double类型的，那么一个三角形可以由三个点来表示
 * 给定三个点代表的三角形，再给定一个点(x,y)，判断(x,y)是否在三角形内部
 */
public class Code_9_5_PointIsInside {

    // 思路：如果一个点在三角形内部，那么从一个点出发，逆时针围绕三角形旋转一圈，那个点始终在走过的边的左侧，即向量积为正
    public static boolean isInside(double x1, double y1, double x2, double y2, double x3, double y3,
                                   double x, double y) {
        // 由于用户输入的各个坐标不固定，不能确定A/B/C各个顶点的位置，因此不好确定旋转的方向
        // （不能判断出旋转的方向是顺时针还是逆时针），但是如果B点在向量A->C的右边的话，A->B->C就是逆时针（都是自己指定的）
        if (func(x3 - x1, y3 - y1, x2 - x1, y2 - y1) >= 0) {
            double tempx2 = x2;
            double tempy2 = y2;
            x2 = x3;
            y2 = y3;
            x3 = tempx2;
            y3 = tempy2;
        }
        if (func(x1 - x3, y1 - y3, x - x3, y - y3) < 0) {
            return false;
        }
        if (func(x2 - x1, y2 - y1, x - x1, y - y1) < 0) {
            return false;
        }
        if (func(x3 - x2, y3 - y2, x - x2, y - y2) < 0) {
            return false;
        }
        return true;
    }

    // 求向量积（可以以此判断一个点在一条线的左边还是右边）
    public static double func(double x1, double y1, double x2, double y2) {
        return x1 * y2 - x2 * y1;
    }

    public static void main(String[] args) {
        System.out.println(isInside(-2, 0, 2, 0, 0, 4, 0, 0));
    }
}
