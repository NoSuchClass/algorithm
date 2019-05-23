package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 汉罗塔问题
 * 刘悦河 201603653
 */
public class Code_8_5_Hanoi {
	public static void hanoi(int N, String from, String to, String help) {
		if (N == 1) {
			System.out.println("将1从" + from + "移到" + to);
			//可以通过一个else省去一个空return
		}else {
			hanoi(N - 1, from, help, to);

			System.out.println("将" + N + "从" + from + "移到" + to);
			hanoi(N - 1, help, to, from);
		}
	}

	public static void main(String[] args) {
		String from = "左";
		String to = "右";
		String help = "中"; 
		int i = 3;
		hanoi(i, from, to, help);
	}
}
