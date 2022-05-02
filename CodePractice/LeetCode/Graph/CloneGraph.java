package LeetCode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph 
{
	HashMap<Node, Node> visited = new HashMap<Node, Node>();
	public Node cloneGraph(Node node) {
		if (node == null)
			return node;
		if (visited.containsKey(node))
			return visited.get(node);
		Node cloneNode = new Node(node.val, new ArrayList());
		visited.put(node, cloneNode);
		for (Node neighbor : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		return cloneNode;
	}
}
