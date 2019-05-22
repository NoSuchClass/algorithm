package com.bitongchong.codinginterviews;

/*
 * 题目描述：
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class Code_05_Fibonacci {
    public int Fibonacci(int n) {
//      if(n == 1){
//          return 1;
//      }
//      if(n == 0){
//          return 0;
//      }
    	/*
    	 * 递归有一个缺陷就是：当给的数据量特别大的时候，会出现栈溢出的情况
    	 * 只有通过尾递归来实现
    	 */
		if (n <= 1) {
			return n;
		}
		return Fibonacci(n - 1)+Fibonacci(n - 2);
  }
}