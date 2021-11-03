/**
Q4. Subarray with given sum

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output

Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation

Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.

*/

package TwoPointers;

import java.util.ArrayList;

class SubarrayWithGivenSum {

	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int n = A.size();
		int curr_sum = A.get(0), start = 0, i;
		for (i = 1; i <= n; i++) {
			while (curr_sum > B && start < i - 1) {
				curr_sum = curr_sum - A.get(start);
				start++;
			}
			if (curr_sum == B) {
				for (int j = start; j <= i - 1; j++) {
					ans.add(A.get(j));

				}
				return ans;
			}
			if (i < n)
				curr_sum = curr_sum + A.get(i);
		}
		ans.add(-1);
		return ans;
	}

	public static void main(String args[]) {
		SubarrayWithGivenSum swgs = new SubarrayWithGivenSum();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		swgs.solve(list, 5);

	}
}
