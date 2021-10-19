/**
 * Aggressive cows
Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 
John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
So the minimum distance will be 2.
Explanation 2:

 
The minimum distance will be 1.

 */
package SearchingII;

import java.util.Arrays;

public class AggressiveCows {

	public int solve(int[] A, int B) {
		// Relating this question to Agressive Cows Question from SPOJ.
		// position array is actually the position of stalls.
		Arrays.sort(A); //[1, 2, 4, 8, 9]
		int maxDistancePossible = A[A.length - 1] - A[0];
		int low = 1;
		int high = maxDistancePossible;

		// Apply the binary search algo starting from 1 and going to
		// max_distance_possible two cows can take.
		int res = 0;
		while (low <= high) {

			// mid is actually used to check whether two cows can have a min
			// distance of mid. If yes, then we will move to right, else left.
			int mid = (low + high) / 2;
			int compare = 0;
			int count = 1;
			for (int i = 1; i < A.length; i++) {
				int dif = A[i] - A[compare];
				if (dif >= mid) {
					count++;
					compare = i;
				}
			}
			if (count >= B) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return res;
	}

	public static void main(String[] s) {
		AggressiveCows ac = new AggressiveCows();
		int A[] = { 1, 2, 4, 8, 9 };
		int res = ac.solve(A, 3);
		System.out.println(res);

	}
}
