package com.bitongchong.test;

public class StringEqualTest {
    static String a = "abc";

    public static void main(String[] args) {
        String a1 = "abc";
        System.out.println(a == a1.intern());
        System.out.println(a == a1);
//        String a2 = new String("abc");
//
//        String b1 = new String("ab");
//        String b2 = "ab";
//
//        System.out.println(a1 == a2);
//        System.out.println(b1 == b2);
    }
}