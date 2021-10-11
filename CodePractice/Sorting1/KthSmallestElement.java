/**
 Kth Smallest Element
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2. 

*/

package Sorting1;

class KthSmallestElement {

	public int kthsmallest(final int[] A, int B) {
        for (int i = 0; i < B; i++) {
            int min = Integer.MAX_VALUE, idx = 0;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    idx = j;
                }
            }
            int tmp = A[i];
            A[i] = A[idx];
            A[idx] = tmp;
        }
        return A[B - 1];
    }

	public static void main(String args[]) {
		KthSmallestElement kthSmallestElement = new KthSmallestElement();
		int A[] = { 2, 1, 4, 3, 2 };
		int x = kthSmallestElement.kthsmallest(A, 3);
		System.out.println("x=" + x);
	}
}
