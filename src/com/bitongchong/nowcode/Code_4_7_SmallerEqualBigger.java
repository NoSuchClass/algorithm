package com.bitongchong.nowcode;
//再修炼一段时间回来简化
/*
 *问题描述：
 *将单向链表按某值划分成左边小、中间相等、右边大的形式【题目】 给定一个单向链表的头节点head，节点的值类型是整型，
 *再给定一个整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot的节点，中间部分都是值等于pivot的节点，
 *右部分都是值大于 pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。 
 *
 *例如：链表9->0->4->5->1，pivot=3。 
 *调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
 *总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。
 *对某部分内部的节点顺序不做要求。
 *
 *进阶： 在原问题的要求之上再增加如下两个要求。在左、中、右三个部分的内部也做顺序要求，
 *要求每部分里的节点从左 到右的顺序与原链表中节点的先后次序一致。 
 *
 *例如：链表9->0->4->5->1，pivot=3。
 *调整后的链表是0->1->9->4->5。 
 *
 *在满足原问题要求的同时，左部分节点从左到右为0、1。
 *在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再讨论；右部分节点 从左到右为9、4、5。
 *在原链表中也是先出现9，然后出现4，最后出现5。如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 */
public class Code_4_7_SmallerEqualBigger {
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	public static Node smallerEqualBigger(Node head, int num) {
		Node smaller = null;
		Node bigger = null;
		Node equal = null;
		Node smallerEnd = null;
		Node biggerEnd = null;
		Node equalEnd = null;
		while(head != null) {
			if (head.value > num) {
//				//节点的next可以为null吗? 可以的
				if (biggerEnd == null) {
					biggerEnd = head;
					bigger = head;
				}else {
					//菜鸡写法
//					biggerEnd.next = new Node(head.value);
//					biggerEnd = biggerEnd.next;
					biggerEnd.next = head;
					//这儿相当于是next了
					biggerEnd = head;
				}
			}else if (head.value == num) {
				if (equalEnd == null) {
					equal = head;
					equalEnd = head;
				}else {
					equalEnd.next = head;
					equalEnd = head;
				}
			}else {
				if (smallerEnd == null) {
					smaller = head;
					smallerEnd = head;
				}else {
					smallerEnd.next = head;
					smallerEnd = head;
				}
			}
			head = head.next;
		}
		if (smaller != null && equal != null) {
			smallerEnd.next = equal;
			equalEnd.next = bigger;
			return smaller;
		}else if (smaller != null) {
			smallerEnd.next = bigger;
			return smaller;
		}else if(equal != null){
			equalEnd.next = bigger;
			return equal;
		}else {
			return bigger;
		}
		
	}
	public static void main(String[] args) {
		Node node = null;
		node = new Node(13);
		node.next = new Node(16);
		node.next.next = new Node(34);
		node.next.next.next = new Node(2);
		Node res = smallerEqualBigger(node, 3);
		System.out.println(res.next.next.value);
		System.out.println(node.next.next.value);
	}
}
