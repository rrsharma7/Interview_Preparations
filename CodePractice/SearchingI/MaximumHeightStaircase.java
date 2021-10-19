/**
 * Maximum height of staircase
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.

The first stair would require only one block, the second stair would require two blocks and so on.

Find and return the maximum height of the staircase.



Problem Constraints
0 <= A <= 109


Input Format
The only argument given is integer A.



Output Format
Return the maximum height of the staircase using these blocks.



Example Input
Input 1:

 A = 10
Input 2:

 20


Example Output
Output 1:

 4
Output 2:

 5
 */
package SearchingI;

public class MaximumHeightStaircase {

	public int solve(int A) {
		int sum = 0, i = 1;
		while (sum < A) {
			sum =sum+ i;
			i++;
		}
		return sum != A ? i - 2 : i - 1;
	}

	public static void main(String[] s) {
		MaximumHeightStaircase asp = new MaximumHeightStaircase();
		int res = asp.solve(11);
		System.out.println(res);

	}
}
