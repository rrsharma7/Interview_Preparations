/**
Q5. Min Sum Path in Triangle

Problem Description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



Problem Constraints

|A| <= 1000

A[i] <= 1000



Input Format

First and only argument is the vector of vector A defining the given triangle



Output Format

Return the minimum sum



Example Input

Input 1:

 
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output

Output 1:

 11
Output 2:

 1


Example Explanation

Explanation 1:

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:

 Only 2 can be collected.
*/

package DynamicProgramming4;

import java.util.ArrayList;

class MinSumPathTriangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
		int m;
		m = A.size();
		int[] dp = new int[m + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + A.get(i).get(j);
			}
			m--;
		}
		return dp[0];
	}
//	2
//	34
//	657
//	4183

	public static void main(String[] args) {
		MinSumPathTriangle mspt = new MinSumPathTriangle();
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		mainList.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		mainList.add(list);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		mainList.add(list);
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		mainList.add(list);
		int ans = mspt.minimumTotal(mainList);
		System.out.println(ans);
	}
}