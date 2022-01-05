/**
Q5. Max Sum Without Adjacent Elements

Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.



Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000



Input Format

The first and the only argument of input contains a 2d matrix, A.



Output Format

Return an integer, representing the maximum possible sum.



Example Input

Input 1:

 A = [   
        [1]
        [2]    
     ]
Input 2:

 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]


Example Output

Output 1:

 2
Output 2:

 8


Example Explanation

Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5.
*/

package DynamicProgramming1;

import java.util.ArrayList;

class MaxSumWithoutAdjacentElements {

	public int adjacent(ArrayList<ArrayList<Integer>> A) {
		
		int n;
		int dp[];
		ArrayList<Integer> first, second;
		first = A.get(0);
		second = A.get(1);
		n = A.get(0).size();
		if (n == 0)
		return 0;
		dp = new int[n];
		dp[0] = Math.max(first.get(0), second.get(0));

		if (n < 2)
			return dp[0];
		dp[1] = Math.max(first.get(1), second.get(1));
		dp[1] = Math.max(dp[0], dp[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(first.get(i), second.get(i));
			dp[i] = dp[i]+dp[i - 2];
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		MaxSumWithoutAdjacentElements ms = new MaxSumWithoutAdjacentElements();
		ArrayList<ArrayList<Integer>> mainList=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		mainList.add(list1);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		mainList.add(list2);
		int ans = ms.adjacent(mainList);
		System.out.println(ans);
	}

}