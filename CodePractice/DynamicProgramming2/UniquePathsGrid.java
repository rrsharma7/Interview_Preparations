/**
Q1. Unique Paths in a Grid

Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.



Problem Constraints

1 <= n, m <= 100
A[i][j] = 0 or 1



Input Format

Firts and only argument A is a 2D array of size n * m.



Output Format

Return an integer denoting the number of unique paths from (1, 1) to (n, m).



Example Input

Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output

Output 1:

 2
Output 2:

 0


Example Explanation

Explanation 1:

 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 
Explanation 2:

 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
*/

package DynamicProgramming2;

class UniquePathsGrid {

	int[][] cache = null;
	public int uniquePathsWithObstacles(int[][] A) {
		int n = A.length - 1;
		int m = A[0].length - 1;
		if (A[0][0] == 1 || A[n][m] == 1)
			return 0;
		cache = new int[A.length][A[0].length];
		initializeCache();
		cache[0][0] = 1;
		dp(A);
		return cache[n][m];
	}

	public void dp(int[][] A) {

		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				if (A[i][j] == 1) {
					cache[i][j] = 0;
				} else if (i - 1 < 0 && j - 1 >= 0) {
					cache[i][j] = cache[i][j - 1];
				} else if (j - 1 < 0 && i - 1 >= 0) {
					cache[i][j] = cache[i - 1][j];
				} else if (j - 1 >= 0 && i - 1 >= 0) {
					cache[i][j] = cache[i][j - 1] + cache[i - 1][j];
				}
				// System.out.println("i "+i+" j"+j+" cache[i][j] "+cache[i][j]);
			}
		}
	}

	public void initializeCache() {

		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				cache[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		UniquePathsGrid uniquePathsGrid = new UniquePathsGrid();
		int a[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ans = uniquePathsGrid.uniquePathsWithObstacles(a);
		System.out.println(ans);
	}

}