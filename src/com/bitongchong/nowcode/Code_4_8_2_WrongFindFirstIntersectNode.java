package com.bitongchong.nowcode;

//作用：判断带环单链表的入环口的位置
//如果一个函数要调用两次，每次传入参数不同或相同，如果第一个调用没有问题，第二个出现问题，然后去掉
//第一个单独运行第二个调用，又发现没有问题，那么多半是第一次调用时进入了不同的判断分支，并且改变了
//两个调用共同依赖对象的结构
public class Code_4_8_2_WrongFindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		Node loop2 = findLoop(head2);
//		System.out.println("head1入环口的位置是："+loop1.value);
		System.out.println("head2入环口的位置是："+loop2.value);
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
			
			//为什么能够访问到head1传进来的数值呢？
			//难道能够从一个带环链表访问到另外一个与之相交的带环链表的非相交部分吗？
			//可能原因：因为在第一次判断head1的入环口时，改变了链表原有结构，导致看起来好像能够访问（因为打印数据时也有点问题），实际上是不能的
			System.out.println("调用过程中产生的数值"+faster.value);
		}
		
		//这一行去掉.next.next时就访问不到1 、 3这些原本属于head1中的数值了
		faster.next.next = head;
		
		while(faster != lower) {
			faster = faster.next;
			lower = lower.next;
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
