package com.bitongchong.codinginterviews;
import java.util.ArrayList;

/*
 * 题目描述：
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Code_03_PrintListFromTailToHead {
	
	public static class ListNode {
		int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> resList = new ArrayList<Integer>();
		if(listNode == null) {
			return resList;
		}
		func(listNode, resList);
		return resList;
	}

	public static void func(ListNode listNode, ArrayList<Integer> resList) {
		if(listNode == null) {
			return;
		}
		// 这儿非常妙，因为需要循环到最后一个链表节点再往回加值，但是如果直接listNode=listNode.next
		// 的话，这儿就取不了第一个的值了，因此这儿直接将listNode.next当做参数传进去，那么就能够取到第一个数的值了
		func(listNode.next, resList);
		resList.add(listNode.val);
	}
 
	public static void main(String[] args) {
		ListNode node = new ListNode(58);
		node.next = new ListNode(34);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(67);
		ArrayList<Integer> integers = printListFromTailToHead(node);
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}
