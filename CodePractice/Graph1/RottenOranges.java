/**
Q3. Rotten Oranges

Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2

Input Format

The first argument given is the integer matrix A.

Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:

 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output

Output 1:

 4
Output 2:

 -1


Example Explanation

Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:

 Task is impossible
*/

package Graph1;

import java.util.ArrayDeque;

class RottenOranges {
	public int solve(int[][] A) {
		int[][] time = new int[A.length][A[0].length];
		ArrayDeque<Pair> q = new ArrayDeque<Pair>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 2) {
					time[i][j] = 0;
					q.addLast(new Pair(i, j));
				} else {
					time[i][j] = -1;
				}
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.pop();
			int x = p.x;
			int y = p.y;
			if (x + 1 >= 0 && x + 1 < A.length && y >= 0 && y < A[0].length && A[x + 1][y] == 1
					&& time[x + 1][y] == -1) {
				q.addLast(new Pair(x + 1, y));
				time[x + 1][y] = time[x][y] + 1;
			}
			if (x >= 0 && x < A.length && y + 1 >= 0 && y + 1 < A[0].length && A[x][y + 1] == 1
					&& time[x][y + 1] == -1) {
				q.addLast(new Pair(x, y + 1));
				time[x][y + 1] = time[x][y] + 1;
			}
			if (x - 1 >= 0 && x - 1 < A.length && y >= 0 && y < A[0].length && A[x - 1][y] == 1
					&& time[x - 1][y] == -1) {
				q.addLast(new Pair(x - 1, y));
				time[x - 1][y] = time[x][y] + 1;
			}
			if (x >= 0 && x < A.length && y - 1 >= 0 && y - 1 < A[0].length && A[x][y - 1] == 1
					&& time[x][y - 1] == -1) {
				q.addLast(new Pair(x, y - 1));
				time[x][y - 1] = time[x][y] + 1;
			}
		}

		int max = -1;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (time[i][j] == -1 && A[i][j] == 1) {
					return -1;
				}
				max = Integer.max(max, time[i][j]);
			}
		}
		return max;
	}

	class Pair {
		int x;
		int y;

		public Pair(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}

	public static void main(String[] args) {
		RottenOranges ro = new RottenOranges();
		int[][] B = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int ans = ro.solve(B);
		System.out.println(ans);
	}

}