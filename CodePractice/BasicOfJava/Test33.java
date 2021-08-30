package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test33 {
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, ArrayList<Node>> hashMap = new HashMap<>();
		int n;
		int sum;
		ArrayList<Node> nodes;
		Node curNode;
		n = A.size();
		if (A == null || A.size() < 4)
			return res;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum = A.get(i) + A.get(j);
				curNode = new Node(i, j);
				if (hashMap.containsKey(sum)) {
					nodes = hashMap.get(sum);
				} else {
					nodes = new ArrayList<>();
				}
				nodes.add(curNode);
				hashMap.put(sum, nodes);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum = A.get(i) + A.get(j);
				curNode = new Node(i, j);
				if (hashMap.containsKey(sum)) {
					nodes = hashMap.get(sum);
					for (Node node : nodes) {
						if (overlaps(curNode, node))
							continue;
						res.add(curNode.i);
						res.add(curNode.j);
						res.add(node.i);
						res.add(node.j);
						return res;
					}
				}
			}
		}
		return res;
	}

	public boolean overlaps(Node n1, Node n2) {
		if (n1.i == n2.i || n1.i == n2.j || n1.j == n2.i || n1.j == n2.j)
			return true;
		return false;
	}

	class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Test33 test26 = new Test33();
		ArrayList<Integer> test = new ArrayList<>();
		test.add(3);
		test.add(4);
		test.add(7);
		test.add(1);
		test.add(2);
		test.add(9);
		test.add(8);
		test26.solve(test);
	}
}
