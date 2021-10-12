/**
 * Single Number III
Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
First argument is an array of interger of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once
 */
package BitManipulation;

public class SingleNumberIII {

	public int[] solve(int[] A) {
        int aXorb = 0; // the result of a xor b;
        for (int item: A)
            aXorb = aXorb^item;
   
        int lastBit = (aXorb & (aXorb - 1)) ^ aXorb; // the last bit that a diffs b
        int intA = 0, intB = 0;
        for (int item: A) {
            // based on the last bit, group the items into groupA(include a) and groupB
            if ((item & lastBit) != 0)
                intA = intA ^ item;
            else
                intB = intB ^ item;
        }
        int x = Math.min(intA, intB), y = Math.max(intA, intB);
        int[] ans = new int[2];
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
	public static void main(String[] s) {
		SingleNumberIII siii = new SingleNumberIII();
		int arr[]= {1, 2, 3, 1, 2, 4};
		siii.solve(arr);

	}
}
