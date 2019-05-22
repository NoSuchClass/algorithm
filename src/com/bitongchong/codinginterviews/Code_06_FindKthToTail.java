package com.bitongchong.codinginterviews;

/*
 * 问题描述：
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Code_06_FindKthToTail {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// 垃圾解法，绝对没offer
	// 遍历一遍，找到链表长度，在计算倒数k个节点
	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode node = head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		if (k > count) {
			return null;
		}
		for (int i = 0; i < count - k; i++) {
			head = head.next;
		}
		return head;
	}

	// 改良一点的错误算法，但是只能通过百分之五十的测试用例，而且当k>链表长度时是不能够判断的
	// 就是正确解法的差一点点
	public ListNode FindKthToTail2(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode node = head;
		ListNode node2 = head;
		while (node != null) {
			for (int i = 0; i < k; i++) {
				if (node != null) {
					node = node.next;
				} else {
					break;
				}
			}
			if (node != null) {
				node2 = node2.next;
			}
		}
		return node2;
	}

	// 参考大佬的最优解（？）
	public ListNode FindKthToTail3(ListNode head, int k) {
		// 又忘了提前判空，与链表相关的题，一定要提前判断传入的链表是不是为空的
		if (head == null || k <= 0) {
			return null;
		}
		ListNode node = head;
		ListNode node2 = head;
		for (int i = 0; i < k - 1; i++) {
			// 注意此处的判断条件
			if (node.next != null) {
				node = node.next;
			} else {
				return null;
			}
		}
		while (node.next != null) {
			node = node.next;
			node2 = node2.next;
		}
		return node2;
	}

	// 看到的一些大佬的炫技代码
	public ListNode FindKthToTail4(ListNode head, int k) {
		ListNode p, q;
		p = q = head;
		int i = 0;
		//如果k为零，恰好q也指到null，也不知道是巧合还是大佬提前就考虑到了的
		for (; p != null; i++) {
			if (i >= k)
				q = q.next;
			p = p.next;
		}
		//i的作用也相当于是对p做了一个长度的记录
		return i < k ? null : q;
	}
	/*
	 * 这道题其实就只需要处理两个点：
	 * 第一个是如果输入的k为零
	 * 第二个是如果输入的k比链表长
	 */
}
