package com.bitongchong.classicalproblem;

/*
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 * 母牛，假设不会死。求N年后，母牛的数量
 */
public class Code_8_7_HowManyCows {
	public static int howManyCows(int n) {
		if (n <= 4) {
			return n;
		}
		return howManyCows(n - 1) + howManyCows(n - 3);
	}

	public static void main(String[] args) {
		System.out.println(howManyCows(6));
	}
}
