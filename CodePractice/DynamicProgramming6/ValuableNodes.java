/**
Q2. Valuable Nodes
Problem Description

Given a tree T containing N nodes numbered [1,2, …, N] rooted at node 1.

Each node has a value associated with it. You need to choose some of the nodes from the tree such that the sum of values of the chosen nodes is maximum possible.

Moreover, if you have chosen a node V you cannot choose any of its children or grand children.

In simple words, you have to choose a subset of nodes such that no two nodes in the chosen set have a parent-child relation or grandfather-grandchild relation between them.



Problem Constraints

1 <= N <= 500000

1 <= val <= 10000



Input Format

First argument is the vector A, where A[i] denotes parent of i+1

Second argument is the vector B, where B[i] if the value associated with node i+1



Output Format

Return an integer containing the maximum possible sum. (As the answer can be large, output the answer modulo 1000000007)



Example Input

Input 1:

A = [0]
B = [1]
Input 2:

A = [0, 1, 2, 3]
B = [1, 50, 3, 4]


Example Output

Output 1:

 1
Output 2:

 50


Example Explanation

Explanation 1:

 Only node 1 is taken.
Explanation 2:

 Only node 2 is taken.
*/

package DynamicProgramming6;

import java.util.*;

class ValuableNodes {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	Map<Integer, List<Integer>> ggcMap;
	Map<Integer, List<Integer>> childMap;
	int[] B;

	int[] dp;
	int MOD = 1000000007;

	public int solve(int[] A, int[] B) {
		int ans = 0;
		this.B = B;
		ggcMap = new HashMap<>();
		childMap = new HashMap<>();
		dp = new int[A.length + 1];
		Arrays.fill(dp, -1);
		for (int i = 1; i <= A.length; i++) {

			int node = i;
			Integer parent = A[i - 1];
			Integer ggp = null;
			// parent child
			List<Integer> temp = childMap.get(parent);
			if (temp == null) {
				temp = new ArrayList<>();
				childMap.put(parent, temp);
			}
			temp.add(node);
			// find great grand child
			try {
				ggp = A[A[A[i - 1] - 1] - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				// suppressing Exception if there is not ggp
				continue;
			}
			List<Integer> l = ggcMap.get(ggp);

			if (l == null) {
				l = new ArrayList<>();
				ggcMap.put(ggp, l);
			}
			l.add(node);

		}

		ans = maxSum(1);
		return ans;
	}

	public int maxSum(int i) {
		if (dp[i] != -1)
			return dp[i];
		int noTake = 0;
		for (int k : childMap.getOrDefault(i, Collections.emptyList())) {
			noTake = (noTake + maxSum(k)) % MOD;
		}
		// considering weight at i-1 fo current node
		int take = B[i - 1];
		for (int k : ggcMap.getOrDefault(i, Collections.emptyList())) {
			take = (take + maxSum(k)) % MOD;
		}
		dp[i] = Math.max(take, noTake);
		return dp[i];

	}
	public static void main(String[] args) {
		ValuableNodes vn = new ValuableNodes();
		int a[] = { 0, 1, 2, 3 };
		int b[] = { 1, 50, 3, 4 };
		int ans = vn.solve(a, b);
		System.out.println(ans);
	}

}