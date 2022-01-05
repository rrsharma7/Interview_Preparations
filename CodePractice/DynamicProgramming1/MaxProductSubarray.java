/**
Q2. Max Product Subarray
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.



Problem Constraints

1 <= N <= 5 * 105

-100 <= A[i] <= 100



Input Format

First and only argument is an integer array A.



Output Format

Return an integer corresponding to the maximum product possible.



Example Input

Input 1:

 A = [4, 2, -5, 1]
Input 2:

 A = [-3, 0, -5, 0]


Example Output

Output 1:

 8
Output 2:

 0


Example Explanation

Explanation 1:

 We can choose the subarray [4, 2] such that the maximum product is 8.
Explanation 2:

 0 will be the maximum product possible.
*/

package DynamicProgramming1;

class MaxProductSubarray {

	 public int maxProduct(final int[] A) {
		    return maxProductC(A, A.length);
		  }
		  static int maxProductC(int arr[], int n) {

		    // Variables to store maximum and minimum 
		    // product till ith index. 
		    int minVal = arr[0];
		    int maxVal = arr[0];

		    int maxProduct = arr[0];

		    for (int i = 1; i < n; i++) {

		      // When multiplied by -ve number, 
		      // maxVal becomes minVal 
		      // and minVal becomes maxVal. 
		      if (arr[i] < 0) {
		        int temp = maxVal;
		        maxVal = minVal;
		        minVal = temp;

		      }

		      // maxVal and minVal stores the 
		      // product of subarray ending at arr[i]. 
		      maxVal = Math.max(arr[i], maxVal * arr[i]);
		      minVal = Math.min(arr[i], minVal * arr[i]);

		      // Max Product of array. 
		      maxProduct = Math.max(maxProduct, maxVal);
		    }

		    // Return maximum product found in array. 
		    return maxProduct;
		  }
	public static void main(String[] args) {
		MaxProductSubarray wtd = new MaxProductSubarray();
		int a[] = { 4, 2, -5, 1 };
		int ans = wtd.maxProduct(a);
		System.out.println(ans);
	}

}