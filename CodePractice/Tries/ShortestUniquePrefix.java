/**
Q1. Shortest Unique Prefix

Problem Description

Given a list of N words. Find shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is prefix of another. In other words, the representation is always possible



Problem Constraints

1 <= Sum of length of all words <= 106



Input Format

First and only argument is a string array of size N.



Output Format

Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input

Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output

Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]


Example Explanation

Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:

 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.

*/

package Tries;

import java.util.ArrayList;

class ShortestUniquePrefix {
	private Node root;

	public String getPrefix(String str) {
		StringBuilder strB = new StringBuilder();
		return get(root, str, 0, strB);
	}

	public String get(Node node, String str, int index, StringBuilder strB) {
		char c = str.charAt(index);
		if (c < node.c) {
			return get(node.left, str, index, strB);
		} else if (c > node.c) {
			return get(node.right, str, index, strB);
		} else if (node.val == 1) {
			strB.append(node.c);
			return strB.toString();
		} else {
			strB.append(node.c);
			return get(node.mid, str, index + 1, strB);
		}
	}

	public Node put(Node node, String str, int index) {
		if (index == str.length())
			return node;
		if (node == null)
			node = new Node(str.charAt(index));
		char c = str.charAt(index);
		if (c < node.c) {
			node.left = put(node.left, str, index);
		} else if (c > node.c) {
			node.right = put(node.right, str, index);
		} else {
			node.mid = put(node.mid, str, index + 1);
			node.val += 1;
		}
		return node;
	}

	class Node {
		char c;
		int val;
		Node left, mid, right;

		public Node() {
		}

		public Node(char c) {
			this.c = c;
			this.val = 0;
		}
	}

	public ArrayList<String> prefix(ArrayList<String> A) {
		ArrayList<String> res = new ArrayList<>();
		for (String str : A) {
			put(str);
		}
		for (String str : A) {
			String prefix = getPrefix(str);
			res.add(prefix);
		}
		return res;
	}

	public void put(String str) {
		root = put(root, str, 0);
	}

	public static void main(String[] args) {
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		ArrayList<String> strList=new ArrayList<String>();
		strList.add("zebra");
		strList.add("dog");
		strList.add("duck");
		strList.add("dove");
		ArrayList<String> list = sup.prefix(strList);
		list.forEach(System.out::println);
	}

}
