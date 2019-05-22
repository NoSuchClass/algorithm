package com.bitongchong.nowcode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * 知识补充：
 * 并查集：
 * 并查集，在一些有N个元素的集合应用问题中，我们通常是在开始时让每个元素构成一个单元素的集合，然后按一定顺序将属于同一组的元素所在的集合合并，
 * 其间要反复查找一个元素在哪个集合中。这一类问题近几年来反复出现在信息学的国际国内赛题中，其特点是看似并不复杂，但数据量极大，
 * 若用正常的数据结构来描述的话，往往在空间上过大，计算机无法承受；即使在空间上勉强通过，运行的时间复杂度也极高，
 * 根本就不可能在比赛规定的运行时间（1～3秒）内计算出试题需要的结果，只能用并查集来描述。
 * 并查集是一种树型的数据结构，用于处理一些不相交集合（Disjoint Sets）的合并及查询问题。常常在使用中以森林来表示。
 * 
 * 
 */
public class Code_7_1_UnionFind {
	public static class Node{
		
	}
	public static class UnionFindSet{
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;
		
		public UnionFindSet(List<Node> nodes) {
			makeSets(nodes);
		}
		
		private void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for(Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		private Node findHead(Node node) {
			Stack<Node> stack = new Stack<>();
			Node father = null;
			while(father != node) {
				father = fatherMap.get(node);
				stack.push(node);
				node = father;
			}
			while(!stack.isEmpty()) {
				fatherMap.put(stack.pop(), father);
			}
			return father;
//			Node father = fatherMap.get(node);
//			if (node != father) {
//				father = findHead(father);
//			}
//			fatherMap.put(node, father);
//			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}
		
		public void union(Node a, Node b) {
			if (a != null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSize = sizeMap.get(aHead);
				int bSize = sizeMap.get(bHead);
				if (aSize < bSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(aHead, aSize + bSize);
				}else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(bHead, aSize + bSize);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
