package com.bitongchong.classicalproblem;

import java.util.HashMap;


/*
 * 问题描述：
 * 复制含有随机指针节点的链表【题目】 一种特殊的链表节点类描述如下：
 * public class Node { 
 * 		public int value; 
 * 		public Node next; 
 * 		publicNode rand;
 * 		public Node(int data) { 
 * 			this.value = data; 
 * 		}
 * }
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一 样，都指向下一个节点，
 * rand指针是Node类中新增的指针，这个指针可 能指向链表中的任意一个节点，也可能指向null。 
 * 给定一个由Node节点类型组成的无环单链表的头节点head，
 * 请实现一个 函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。 
 * 
 * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数
 */
public class Code_4_9_CopyListWithRandom { 
	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
		Node cur = head;
		while(cur != null) {
			hashMap.put(cur, new Node(cur.value));
			//只有head.next而且head.next.next才会出错
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			hashMap.get(cur).next = hashMap.get(cur.next);
			hashMap.get(cur).rand = hashMap.get(cur.rand);
			cur = cur.next;
		}
		return hashMap.get(head);
	}
	
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node nodeNext = null;
		Node nodeCopy = null;
		Node curNode = head;
		//遍历链表节点的好办法
		while(curNode != null) {
			nodeNext = curNode.next;
			nodeCopy = new Node(curNode.value);
			curNode.next = nodeCopy;
			nodeCopy.next = nodeNext;
			curNode = curNode.next.next;
		}
		curNode = head;
		while(curNode != null) {
			curNode.next.rand = curNode.rand.next;
			curNode = curNode.next.next;
		}
		curNode = head;
		Node resNode = curNode.next;
		while(curNode.next.next != null) {
			nodeCopy = curNode.next;
			curNode.next = curNode.next.next;
			nodeCopy.next = curNode.next.next;
			curNode = curNode.next;
		}
		nodeCopy.next.next = null;
		curNode.next = null;
		
		return resNode;
	}
	
//	public static void printRandLinkedList(Node head) {
//		Node cur = head;
//		while(cur != null) {
//			if (cur.rand != null && cur.next != null) {
//				System.out.println("当前值："+cur.value);
//				System.out.println("next指针值："+cur.next.value);
//				System.out.println("random指针值："+cur.rand.value);
//			}else if (cur.rand != null) {
//				System.out.println("当前值："+cur.value);
//				System.out.println("next指针值："+null);
//				System.out.println("random指针值："+cur.rand.value);
//			}else {
//				System.out.println("当前值："+cur.value);
//				System.out.println("next指针值："+null);
//				System.out.println("random指针值："+null);
//			}
//			cur = cur.next;
//		}
//	}
    public static Node Clone(Node pHead){
//      HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//      RandomListNode cur = pHead;
//      while(cur != null){
//          map.put(cur, new RandomListNode(cur.label));
//          cur = cur.next;
//      }
//      cur = pHead;
//      while(cur != null){
//          map.get(cur).next = map.get(cur.next);
//          map.get(cur).random = map.get(cur.random);
//          cur = cur.next;
//      }
//      如果为空的话，依旧能够取到null值
//      return map.get(pHead);
      if(pHead == null){
          return null;
      }
      Node copyNode = null;
      Node nextNode = null;
      Node curNode = pHead;
      while(curNode != null){
          nextNode = curNode.next;
          copyNode = new Node(curNode.value);
          curNode.next = copyNode; 
          copyNode.next = nextNode;
          curNode = curNode.next.next;
      }
      curNode = pHead;
      while(curNode != null){
          if (curNode.rand != null) {
        	  curNode.next.rand = curNode.rand.next;
              curNode = curNode.next.next;
		}else {
			curNode.next.rand = null;
		}
      }
      curNode = pHead;
      Node resNode = pHead.next;
      while( curNode.next.next != null){
          copyNode = resNode;
          curNode.next = curNode.next.next;
          copyNode.next = curNode.next.next;
          curNode = curNode.next;
      }
      curNode.next = null;
      copyNode.next.next = null;
      return resNode;
  }
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
//
//		head.rand = head.next.next.next.next.next; // 1 -> 6
//		head.next.rand = head.next.next.next.next.next; // 2 -> 6
//		head.next.next.rand = head.next.next.next.next; // 3 -> 5
//		head.next.next.next.rand = head.next.next; // 4 -> 3
//		head.next.next.next.next.rand = null; // 5 -> null
//		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
//
//		printRandLinkedList(head);
//		res1 = copyListWithRand1(head);
//		printRandLinkedList(res1);
//		res2 = copyListWithRand2(head);
		Node res3 = Clone(head);
		printRandLinkedList(res3);
//		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}

}
