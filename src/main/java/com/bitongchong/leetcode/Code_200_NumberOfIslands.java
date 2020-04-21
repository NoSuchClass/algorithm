package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/21 10:04
 */
public class Code_200_NumberOfIslands {
    int res = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    process(i, j, grid);
                }
            }
        }
        return res;
    }

    private void process(int i, int j, char[][] grid) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            process(i + 1, j, grid);
            process(i, j + 1, grid);
            process(i, j - 1, grid);
            process(i - 1, j, grid);
        }
    }
    public static void main(String[] args){
       // System.out.println(new Code_200_NumberOfIslands().numIslands(new char[][]{{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'} }));
        System.out.println(new Code_200_NumberOfIslands().numIslands(new char[][]{{'1','1','1'},{'0' ,'1','0'},{'1','1','1'} }));
    }
}
