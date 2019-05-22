package com.bitongchong.nowcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 给定一个字符串类型的数组strs，找到一种拼接方式，
 * 使得把所有字 符串拼起来之后形成的字符串具有最低的字典序。
 */
public class Code_7_4_LowestLexicography {
//	public static class MyComparator implements Comparator<String> {
//		@Override
//		public int compare(String o1, String o2) {
//			return (o1 + o2).compareTo(o2 + o1);
//		}
//	}
	//要使用这个方案，需要证明比较策略（在这儿也是贪心策略）是具有传递性的。
	//但是一般情况下是用对数器来验证贪心策略的正确性，而不是直接验证它的正确性
	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String str = "";
		Arrays.sort(strs,new Comparator<String>() {
			@Override
			public  int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		for (int i = 0; i < strs.length; i++) {
			str += strs[i];
		}
		return str;
	}
	
	public static void main(String[] args) {
		String[] strings = new String[5];
		strings[0] = "d";
		strings[1] = "b";
		strings[2] = "c";
		strings[3] = "a";
		strings[4] = "z";
		System.out.println(lowestString(strings));
	}
}
