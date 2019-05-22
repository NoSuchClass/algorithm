package com.bitongchong.nowcode;

/*
 * 求n的阶乘
 */
public class Code_8_4_Factorial {
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
