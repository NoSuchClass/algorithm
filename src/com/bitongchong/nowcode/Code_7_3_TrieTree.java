package com.bitongchong.nowcode;

/*知识补充：
 * 前缀树：
 * 字典树、单词查找树或键树
 * 典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），
 * 所以经常被搜索引擎系统用于文本词频统计。它的优点是：利用字符串
 * 的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，
 * 查询效率比哈希树高。
 * 
 * 根节点无字符串
 * 每个节点都有分支，每个分支上面的存放值是不同的
 * 可以通过对输入字符进行数据处理（比如建立一个数组，通过字符的assic码
 * 加减，得到的对应值把相应位置的数组值置为1），这样相当于是将字符放在了
 * 节点与节点之间的连线上，可以简化操作
 * 每个节点有一个path值（存放经过此处的字符串）
 * 有一个end值（存放哪些字符串在这个节点停止）
 * 这样就可以统计前缀树中是否存放过某个值，以及存放了几次都能知道
 * 
 * 问题描述：
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？
 * 请打印arr2中出现次数最大的前
 * 
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？请打印
 */
public class Code_7_3_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			TrieNode node = root;
			char[] chs = word.toCharArray();
			int index;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				int index;
				TrieNode node = root;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					// 如果当前节点的下一个节点的path自减1后，他的值为空，那么后面的就都不用减了，直接将
					// 当前节点指向空
					if (--node.nexts[index].path == 0) {
						node.nexts[i] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			} else {
				throw new RuntimeException("需要删除的字符串为不存在");
			}
		}

		public int search(String word) {
			char[] chs = word.toCharArray();
			int index;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				node = node.nexts[index];
				if (node == null) {
					return 0;
				}
			}
			return node.end;
		}

		public int prefixNumber(String word) {
			char[] chs = word.toCharArray();
			int index;
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		String aString = "abc";
		String bString = "bcd";
		String cString = "acd";
		Trie aTrie = new Trie();
		aTrie.insert(aString);
		aTrie.insert(bString);
		aTrie.insert(cString);
		aTrie.insert("");
		aTrie.insert("abd");
		System.out.println(aTrie.prefixNumber("ab"));
	}
}
