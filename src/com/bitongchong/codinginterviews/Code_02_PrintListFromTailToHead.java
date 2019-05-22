package com.bitongchong.codinginterviews;
import java.util.ArrayList;

/*
 * 题目描述：
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Code_02_PrintListFromTailToHead {
	
	public static class ListNode {
		int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
	//我自己写的菜鸡实现
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		//一定要注意边界问题，如果题目没有给出具体参数范围，一定考虑是否为空
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (listNode == null) {
			return arrayList;
		}
		ListNode curNode = listNode;
		ListNode nextNode = listNode.next;
		ListNode tempNode = null;
		curNode.next = null;
		while(nextNode.next != null) {
	        tempNode = nextNode;
	        nextNode = tempNode.next;
	        tempNode.next = curNode;
	        curNode = tempNode;
	    }
	    nextNode.next = curNode;
	    while(nextNode != null) {
	        arrayList.add(nextNode.val);
	        System.out.println(nextNode.val);
	        nextNode = nextNode.next;
	    }
	    return arrayList;
	}
	
	//递归实现，有一点秀
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> resList = new ArrayList<>();
        if(listNode!=null){
        	printListFromTailToHead(listNode.next);
        	resList.add(listNode.val);
		}
		return resList;
	}
 
	public static void main(String[] args) {
		ListNode node = new ListNode(58);
		node.next = new ListNode(34);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(67);
		ArrayList<Integer> integers = printListFromTailToHead2(node);
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}
