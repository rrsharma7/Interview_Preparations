/**
Q2. Bob and Queries

Problem Description

Bob has an array A of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

You have to perform three types of query, in each query you are given three integers x, y and z.

if x = 1: Update the value of A[y] to 2 * A[y] + 1.
if x = 2: Update the value A[y] to ⌊A[y]/2⌋ , where ⌊⌋ is Greatest Integer Function.
if x = 3: Take all the A[i] such that y <= i <= z and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



Problem Constraints

1 <= N, Q <= 100000
1 <= y, z <= N
1 <= x <= 3



Input Format

The first argument has the integer A.
The second argument is a 2d matrix B, of size Q x 3, representing the queries.



Output Format

Return an array of integers where ith index represents the answer of the ith type 3 query.



Example Input

Input 1:

 A = 5
 B = [   
        [1, 1, -1]
        [1, 2, -1]
        [1, 3, -1]   
        [3, 1, 3] 
        [3, 2, 4]   
     ]
Input 2:

 A = 5
 B = [   
        [1, 1, -1]
        [1, 2, -1]
        [3, 1, 3]
        [2, 1, -1]
        [3, 1, 3]   
     ]


Example Output

Output 1:

 [3, 2]
Output 2:

 [2, 1]


Example Explanation

Explanation 1:

 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 After query 3, A => [1, 1, 1, 0, 0]
 For query 4, Concatenation of Binary String between index 1 and 3 : 111. So, number of 1's = 3
 For query 5, Concatenation of Binary String between index 2 and 4 : 110. So, number of 1's = 2
 So, output array is [3, 2].
Explanation 2:

 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 For query 3, Concatenation of Binary String between index 1 and 3 : 110. So, number of 1's = 2
 After query 4, A => [0, 1, 0, 0, 0]
 For query 5, Concatenation of Binary String between index 2 and 4 : 010. So, number of 1's = 1.
 So, output array is [2, 1].
 

*/

package SegmentTrees;

import java.util.ArrayList;
import java.util.List;

class BobAndQueries {
	public int[] solve(int A, int[][] B) {

		SegmentTree segmentTree = new SegmentTree(A);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			if (B[i][0] == 1) {
				segmentTree.update(B[i][1] - 1, val -> 2 * val + 1);
			} else if (B[i][0] == 2) {
				segmentTree.update(B[i][1] - 1, val -> val / 2);
			} else {
				list.add(segmentTree.rangeQuery(B[i][1] - 1, B[i][2] - 1));
			}
		}

		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	class SegmentTree {

		Info[] tree;
		int n = 0;
		SegmentTree(int input) {

			this.n = input;
			tree = new Info[4 * n];
			this.buildTree(0, n - 1, 0);
		}

		private void buildTree(int rStart, int rEnd, int pos) {
			for (int i = 0; i < tree.length; i++) {
				tree[i] = new Info(0, 0);
			}

		}

		public void update(int index, java.util.function.Function<Integer, Integer> function) {

			update(0, n - 1, index, 0, function);
		}

		private void update(int rSatrt, int rEnd, int index, int pos,
				java.util.function.Function<Integer, Integer> function) {

			if (rSatrt > rEnd) {
				return;
			}

			if (rSatrt == rEnd && rSatrt == index) {

				Info info = tree[pos];
				info.val = function.apply(info.val);
				info.countOf1 = bitFunction(info.val);

				return;
			}

			int mid = (rSatrt + rEnd) / 2;
			if (index <= mid) {

				update(rSatrt, mid, index, left(pos), function);
			} else {

				update(mid + 1, rEnd, index, right(pos), function);
			}
			if (tree[pos] == null) {
				tree[pos] = new Info(0, 0);
			}
			if (tree[left(pos)] == null) {
				tree[left(pos)] = new Info(0, 0);
			}
			if (tree[right(pos)] == null) {
				tree[right(pos)] = new Info(0, 0);
			}
			tree[pos].countOf1 = operator(tree[left(pos)].countOf1, tree[right(pos)].countOf1);
		}

		public int rangeQuery(int qStart, int qEnd) {
			return rangeQuery(0, n - 1, qStart, qEnd, 0);
		}

		public int rangeQuery(int rStart, int rEnd, int qStart, int qEnd, int pos) {

			if (rStart > rEnd) {
				return 0;
			}

			if (qStart <= rStart && rStart <= rEnd && qEnd >= rEnd) {

				return tree[pos].countOf1;
			}

			if (qEnd < rStart || qStart > rEnd) {

				return 0;
			}

			int mid = (rStart + rEnd) / 2;
			int leftCountOf1 = rangeQuery(rStart, mid, qStart, qEnd, left(pos));
			int rightCountOf1 = rangeQuery(mid + 1, rEnd, qStart, qEnd, right(pos));

			return operator(leftCountOf1, rightCountOf1);
		}

		private int operator(int valL, int valR) {

			return valL + valR;
		}

		private int bitFunction(int val) {
			int count = 0;

			for (int i = 0; i < 32; i++) {
				if ((val & (1 << i)) != 0)
					count++;
			}
			return count;
		}

		private int left(int i) {

			return 2 * i + 1;
		}

		private int right(int i) {

			return 2 * i + 2;
		}

		private void printTree() {
			for (int i = 0; i < tree.length; i++) {
				System.out.println("index " + i + tree[i] + ",");
			}
			System.out.println();
		}

		class Info {

			Info(int val, int countOf1) {
				this.val = val;
				this.countOf1 = countOf1;
			}

			int val;
			int countOf1;

			public String toString() {
				return " val " + val + " countOf1 " + countOf1;
			}
		}
	}

	public static void main(String[] args) {
		BobAndQueries bq = new BobAndQueries();
		int B[][] = {{1, 1, -1},{1, 2, -1},{1, 3, -1},{3, 1, 3},{3, 2, 4}};
		int ans[] = bq.solve(5, B);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
