/**
Q1. Range Minimum Query

Problem Description

Given an integer array A of size N.

You have to perform two types of query, in each query you are given three integers x,y,z.

If x = 0, then update A[y] = z.
If x = 1, then output the minimum element in the array A between index y and z inclusive.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109

If x = 0, 1<= y <= N and 1 <= z <= 109

If x = 1, 1<= y <= z <= N



Input Format

First argument is an integer array A of size N.

Second argument is a 2-D array B of size M x 3 denoting queries.



Output Format

Return an integer array denoting the output of each query where value of x is 1.



Example Input

Input 1:

 A = [1, 4, 1]
 B = [ 
        [1, 1, 3]
        [0, 1, 5]
        [1, 1, 2] 
     ]
Input 2:

 A = [5, 4, 5, 7]
 B = [ 
        [1, 2, 4]
        [0, 1, 2]
        [1, 1, 4]
     ]


Example Output

Output 1:

 [1, 4]
Output 2:

 [4, 2]


Example Explanation

Explanation 1:

 For 1st query, the minimum element from range (1, 3) is 1.
 For 2nd query, update A[1] = 5, now A = [5, 4, 1].
 For 3rd query, the minimum element from range (1, 2) is 4.
Explanation 2:

 For 1st query, the minimum element from range (2, 4) is 4.
 For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
 For 3rd query, the minimum element from range (1, 4) is 2.

*/

package SegmentTrees;

import java.util.*;

class RangeMinimumQuery {
	static int maxn = 400009;
	static int[] seg = new int[maxn];

	public int[] solve(int[] A, int[][] B) {
		Arrays.fill(seg, 0);
		build(1, 0, A.length - 1, A);
		int m = B.length;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int x = B[i][0];
			int y = B[i][1];
			int z = B[i][2];
			if (x == 1)
				ans.add(query(1, 0, A.length - 1, y - 1, z - 1));
			else
				upda(1, 0, A.length - 1, y - 1, z);
		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}

	public static void upda(int index, int low, int high, int id, int val) {
		if (low == high) {
			seg[index] = val;
			return;
		}
		int mid = (low + high) / 2;
		if (id <= mid && id >= low)
			upda(2 * index, low, mid, id, val);
		else
			upda(2 * index + 1, mid + 1, high, id, val);
		seg[index] = Math.min(seg[2 * index], seg[2 * index + 1]);
	}

	public static void build(int index, int low, int high, int[] A) {
		if (low == high) {
			seg[index] = A[low];
			return;
		}
		int mid = (low + high) / 2;
		build(2 * index, low, mid, A);
		build(2 * index + 1, mid + 1, high, A);
		seg[index] = Math.min(seg[2 * index], seg[2 * index + 1]);
	}

	public static int query(int index, int low, int high, int l, int r) {
		if (low > high || low > r || high < l)
			return Integer.MAX_VALUE;
		if (low >= l && high <= r)
			return seg[index];
		int mid = (low + high) / 2;
		return Math.min(query(2 * index, low, mid, l, r), query(2 * index + 1, mid + 1, high, l, r));
	}

	public static void main(String[] args) {
		RangeMinimumQuery rmq = new RangeMinimumQuery();
		int A[] = {5, 4, 5, 7};
		int B[][] = {{1, 2, 4},{0, 1, 2},{1, 1, 4}};
		int ans[]=rmq.solve(A,B);
		for(int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
	}

}
