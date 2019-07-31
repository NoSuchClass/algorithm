package com.bitongchong.codinginterviews;
/*
 * 题目描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Code_01_SpaceReplace {
    public static String replaceSpace(StringBuffer str) {
/*		 if(str==null){
		    return null;
		 }
		 for(int i=0;i<str.length();i++){
		     char c = str.charAt(i);
		     if(c==' '){
		    str.replace(i,i+1,"%20");
		     }
		  }
		  return str.toString();   */
		char[] chars = str.toString().toCharArray();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				count++;
			}
		}
		char[] newChars = new char[count * 2 + chars.length];
		int n = newChars.length - 1;
		for (int i = chars.length - 1; i >= 0 ; i--) {
			if (chars[i] == ' ') {
				newChars[n--] = '0';
				newChars[n--] = '2';
				newChars[n--] = '%';
			} else {
				newChars[n--] = chars[i];
			}
		}
		return new String(newChars);
	}
 
    public static void main(String[] args) {
    	StringBuffer str = new StringBuffer("12 3a3 a a");
    	String str1 = replaceSpace(str);
    	System.out.println(str1);
	}
}
