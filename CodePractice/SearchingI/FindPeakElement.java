/**
 * Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.

 */
package SearchingI;

public class FindPeakElement {

	public int solve(int[] A) {
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return A[start];
	}

	public static void main(String[] s) {
		FindPeakElement fpe = new FindPeakElement();
		int A[] = { 5, 17, 100, 11 };
		int res = fpe.solve(A);
		System.out.println(res);

	}
}
