package com.bitongchong.test;

public class Main1 {
    /**
     * 刘悦河 201603653
     */
    public static void LCS(char[] arr1, char[] y, int common_len[][], int b[][]){
        for (int k = 0; k < arr1.length; k++) {
            common_len[k][0] = 0;
        }
        for (int k = 0; k < y.length; k++) {
            common_len[0][k] = 0;
        }
        for (int k = 0; k < arr1.length; k++) {
            for (int l = 0; l < y.length; l++) {
                if (arr1[k - 1] == y[l - 1]){
                    common_len[k][l] = common_len[k - 1][l];
                    b[k][l] = -1;
                }else if (common_len[k -1][l] >= common_len[k][l - 1]){
                    common_len[k][l] = common_len[k - 1][l];
                    b[k][l] = -1;
                }else {
                    common_len[k][l] = common_len[k][l - 1];
                    b[k][l] = 1;
                }
            }
        }
    }
    public static void backtrack(int i, int j, int b[][], char[] x){
        if (i == 0 || j == 0) return;
        else if (b[i][j] == 0){
            backtrack(i - 1, j - 1, b, x);
            System.out.println(x[i - 1]);
        }else if (b[i][j] == -1){
            backtrack(i - 1, j, b, x);
        }else{
            backtrack(i, j - 1, b, x);
        }
    }
    
    public static void main(String[] args){
        System.out.println("ABCD");
    }
}
