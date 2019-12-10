package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 两个单链表相交的一系列问题【题目】 在本题中，单链表可能有环，也可能无环。
 * 给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。
 * 请实现一个函数， 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。 
 * 
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1
 */
public class Code_4_8_3_TrueFindFirstIntersectNode {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		System.out.println("head1入环口的位置是："+loop1.value);
		System.out.println("head1入环口的位置是："+loop2.value);
		return null;
	}

	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node lower = head.next; // n1 -> slow
		Node faster = head.next.next; // n2 -> fast
		while (lower != faster) {
			if (faster.next == null || faster.next.next == null) {
				return null;
			}
			faster = faster.next.next;
			System.out.println("调用过程中产生的数值"+faster.value);
			lower = lower.next;
		}
		faster = head; // n2 -> walk again from head
		while (lower != faster) {
			lower = lower.next;
			faster = faster.next;
		}
		return lower;
	}
	
	public static void main(String[] args) {

		// 1->2->3->4->5->6->7->4...
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->6->4->5->6..
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2));

	}
}
