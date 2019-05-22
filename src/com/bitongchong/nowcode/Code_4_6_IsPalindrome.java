package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。 
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。15->6->15，返回true。 1->2->3，返回false
 * 
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1
 * 
 */
public class Code_4_6_IsPalindrome {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	public static Boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Node n1 = null;// 将要标识中间节点的节点
		Node n2 = null;// 用来存放将要倒置顺序的节点
		Node n3 = null;// 将要用来存储倒置时的下一个节点
		Boolean res = true;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}			
		n1 = slow;// 找到并标识中间节点
		n2 = n1.next;

		n1.next = null;
		
		while(n2.next != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n2.next = n1;
		
		//循环结束后，n2就是最后一个节点的位置
		Node lastNode = n2;//用来表示最后一个结点，同时为了后面还原需要，n2是不能动的
		while(lastNode.next != null ) {
			if (lastNode.value != head.value) {
				res = !res;
				break;
			}
			lastNode = lastNode.next;
			head = head.next;
		}
//		lastNode.next = null;
//		Node n4 = lastNode.next;
//		while(n4.next != null) {
//			n4.next = lastNode;
//			lastNode = n4;
//			n4 = n4.next;
//		}
		//将用户给的node节点
		n3 = n2.next;
		n2.next = null;
		while(n3.next != null) {
			//这儿也可以新建一个Node，但是为了节省空间，可以使用前面定义好后没有使用的Node
			n1 = n3.next;
			n3.next = n2;
			n2 = n3;
			n3 = n1;
		}
		n3.next = n2;
		return res;
	}

	public static void main(String[] args) {
		Node node = null;
		node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(2);
		node.next.next.next = new Node(2);
		node.next.next.next.next = new Node(2);
		node.next.next.next.next.next = new Node(2);
		node.next.next.next.next.next.next = new Node(1);
		System.out.println(isPalindrome(node));
		System.out.println(node.next.next.next.next.next.next.value);
		
	}
}