package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 两个单链表相交的一系列问题【题目】 在本题中，单链表可能有环，也可能无环。
 * 给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。
 * 请实现一个函数， 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。 
 * 
 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1)
 */
public class Code_4_8_1_FindFirstIntersectNode {
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		Node loop1 = findLoop(head1);
		Node loop2 = findLoop(head2);
		if (loop1 != null && loop2 != null) {
			return twoLoop(loop1, loop2, head1, head2);
		}else if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}else {
			return null;
		}
	}
	
	public static Node noLoop(Node head1, Node head2) {
		int n = 0;
		Node head1End = head1;
		Node head2End = head2;
		while(head1End.next != null) {
			n++;
			head1End = head1End.next;
		}
		while(head2End.next != null) {
			n--;
			head2End = head2End.next;
		}
		if (head1End != head2End) {
			return null;
		}
		n = Math.abs(n);
		Node longer = n > 0 ? head1 : head2;
		Node shorter = longer == head1 ? head2 : head1;
		while(n != 0) {
			n--;
			longer = longer.next;
		}
		while(longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}
		return longer;
	}
	
	public static Node twoLoop(Node loop1, Node loop2, Node head1, Node head2) {
		if (loop1 == loop2) {
//			虽然大体逻辑是noloop这样的，但是这两个是有环的链表，直接用的话会出问题（比如一直循环）
//			noLoop(head1, head2);
			int n = 0;
			Node head1End = head1;
			Node head2End = head2;
			while(head1End.next != loop1) {
				n++;
				head1End = head1End.next;
			}
			while(head2End.next != loop2) {
				n--;
				head2End = head2End.next;
			}
			if (head1End != head2End) {
				return null;
			}
			Node longer = n > 0 ? head1 : head2;
			Node shorter = longer == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				longer = longer.next;
			}
			while(longer != shorter) {
				longer = longer.next;
				shorter = shorter.next;
			}
			return longer;
		}
		Node loop3 = loop1;
		while(loop3.next != loop1) {
			if (loop3 == loop2) {
				return loop3;
			}
			loop3 = loop3.next;
		}
		return null;
	}
	
	public static Node findLoop(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node faster = head.next.next;
		Node lower = head.next;
		
		while(faster != lower) {			
			if (faster.next == null || faster.next.next == null) {
				return null;
			}
			faster = faster.next.next;
			lower = lower.next;

		}
		faster.next.next = head;
		while(faster != lower) {
			faster = faster.next;
			lower = lower.next;
		}
		return lower;
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
//		head1.next = new Node(2);
//		head1.next.next = new Node(3);
//		head1.next.next.next = new Node(4);
//		head1.next.next.next.next = new Node(5);
//		head1.next.next.next.next.next = new Node(6);
//		head1.next.next.next.next.next.next = new Node(7);
//
//		// 0->9->8->6->7->null
		Node head2 = new Node(0);
//		head2.next = new Node(9);
//		head2.next.next = new Node(8);
//		head2.next.next.next = head1.next.next.next.next.next; // 8->6
//		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

//		// 0->9->8->2...
//		head2 = new Node(0);
//		head2.next = new Node(9);
//		head2.next.next = new Node(8);
//		head2.next.next.next = head1.next; // 8->2
//		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
//		while(head1.next != null) {
//			System.out.println(head1.value);
//			head1 = head1.next;
//		}
		System.out.println(getIntersectNode(head1, head2).value);

	}
}
