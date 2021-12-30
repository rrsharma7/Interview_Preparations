/**
Q1. Segment Tree?

Problem Description

Given an array A of size N and Q queries. Perform following queries:

1 V 0 append V in the back of array.
2 X V set A[X] = V.
3 X 0 delete A[X]. Note: All element at back of X move forward to occupy void.
4 X Y find sum in range [X, Y].
NOTE: For the query of type 4 X Y, output the sum % 109 + 7.



Problem Constraints

1 <= N,Q <= 100000

1 <= A[i],V <=100000

1 <= X,Y <= N' Where, N' is current size of array.



Input Format

First argument contains an integer array A.

Second argument contains a Q x 3 Matrix B.



Output Format

Return an integer array containing answer to all query of type 4 X Y in chronological order.



Example Input

 A = [1, 2, 5, 3, 4] 
 B = [ [4, 2, 4], 
       [3, 3, 0],
       [1, 6, 0],
       [4, 3, 5] ]


Example Output

 [10, 13]


Example Explanation

 First Query find sum(A[2],A[3],A[4])
 Second Query make A = [1, 2, 3, 4]
 Third Query make A = [1, 2, 3, 4, 6]
 Fourth Query find sum(A[3],A[4],A[5])

*/

package SegmentTrees;

import java.util.*;

class SegmentTree {
	static int maxn = 200009;
	static long mod = 1000000007;
	static long[][] segTree = new long[2][800005];
	static long[] ar = new long[200005];
	static long n, t;

	public int[] solve(int[] A, int[][] B) {
		n = (long) A.length;
		for (long[] row : segTree)
			Arrays.fill(row, 0);
		for (int i = 1; i <= n; i++) {
			ar[i] = (long) A[i - 1];
			update(0, i, ar[i], 1, 1, 200000);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		int m = B.length;
		for (int[] i : B) {
			t = i[0];
			if (t == 1) { // append x in back
				++n;
				ar[(int) n] = (long) i[1];
				update(0, (int) n, ar[(int) n], 1, 1, 200000);
			}
			if (t == 2) { // update ar[x] to Y
				int x, y;
				x = i[1];
				y = i[2];
				int idx = getidx(x);
				update(0, idx, y, 1, 1, 200000);
				ar[idx] = (long) y;
			}
			if (t == 3) { // delete ar[x]
				int x;
				x = i[1];
				int idx = getidx(x);
				update(0, idx, 0, 1, 1, 200000);
				update(1, idx, 1, 1, 1, 200000);

			}
			if (t == 4) { // query sum in [X,Y]
				int idx1 = 0, idx2 = 0, x, y;
				x = i[1];
				y = i[2];
				idx1 = getidx(x);
				idx2 = getidx(y);
				long val = query(0, idx1, idx2, 1, 1, 200000);
				val = val % mod;
				ans.add((int) val);
			}

		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}

	public static void update(int i, int index, long value, int node, int L, int R) {
		if (L == R) { // leaf node
			segTree[i][node] = value;
			return;
		}
		int mid = (L + R) / 2;
		if (index <= mid)
			update(i, index, value, 2 * node, L, mid);
		else
			update(i, index, value, 2 * node + 1, mid + 1, R);

		segTree[i][node] = (segTree[i][2 * node] + segTree[i][2 * node + 1]);
		return;
	}

	public static long query(int i, int l, int r, int node, int L, int R) {
		if (l <= L && R <= r) { // completely inside our range
			return segTree[i][node];
		}
		if (L > r || R < l) { // completely outside our range
			return (long) 0;
		}
		int mid = (L + R) / 2;
		return query(i, l, r, 2 * node, L, mid) + query(i, l, r, 2 * node + 1, mid + 1, R);
	}

	public static int getidx(int x) {
		int lo = 1, hi = (int) n, idx = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int qu = (int) query(1, 1, mid, 1, 1, 200000);
			if ((x + qu) == mid) {
				idx = mid;
				hi = mid - 1;
			} else if ((x + qu) < mid)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return idx;
	}

	public static void main(String[] args) {
		SegmentTree st = new SegmentTree();
		int A[] = {1, 2, 5, 3, 4};
		int B[][] = { {4, 2, 4}, {3, 3, 0}, { 1, 6, 0 },{4, 3, 5} };
		int ans[] = st.solve(A, B);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
