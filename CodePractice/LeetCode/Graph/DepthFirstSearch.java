package Leetcode.Graph;

//An Iterative Java program to do DFS traversal from
//a given source vertex. DFS(int s) traverses vertices
//reachable from s.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class DepthFirstSearch {
	int V;
	LinkedList<Integer>[] adj;

	// Constructor
	DepthFirstSearch(int V) {
		this.V = V;
		adj = new LinkedList[V];

		for (int i = 0; i < adj.length; i++)
			adj[i] = new LinkedList<Integer>();

	}

	// To add an edge to graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
	}

	// prints all not yet visited vertices reachable from s
	void DFS(int s) {
		// Initially mark all vertices as not visited
		Vector<Boolean> visited = new Vector<Boolean>(V);
		for (int i = 0; i < V; i++)
			visited.add(false);

		// Create a stack for DFS
		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(s);

		while (stack.empty() == false) {
			// Pop a vertex from stack and print it
			s = stack.peek();
			stack.pop();

			// Stack may contain same vertex twice. So
			// we need to print the popped item only
			// if it is not visited.
			if (visited.get(s) == false) {
				System.out.print(s + " ");
				visited.set(s, true);
			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then push it
			// to the stack.
			Iterator<Integer> itr = adj[s].iterator();

			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited.get(v))
					stack.push(v);
			}

		}
	}

	// Driver program to test methods of graph class
	public static void main(String[] args) {
		// Total 5 vertices in graph
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch(5);

		depthFirstSearch.addEdge(1, 0);
		depthFirstSearch.addEdge(0, 2);
		depthFirstSearch.addEdge(2, 1);
		depthFirstSearch.addEdge(0, 3);
		depthFirstSearch.addEdge(1, 4);

		System.out.println("Following is the Depth First Traversal");
		depthFirstSearch.DFS(2);
	}
}
