/**
Q4. Ath largest element

Problem Description

Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i] where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements then output array should be -1 at the ith index.



Problem Constraints

1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX



Input Format

First argument is an integer A.
Second argument is an integer array B of size N.



Output Format

Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].



Example Input

Input 1:

 A = 4  
 B = [1 2 3 4 5 6] 
Input 2:

 A = 2
 B = [15, 20, 99, 1]


Example Output

Output 1:

 [-1, -1, -1, 1, 2, 3]
Output 2:

 [-1, 15, 20, 20]


Example Explanation

Explanation 1:

 for i <= 3 output should be -1.
 for i = 4 , Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 for i = 5 , Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 for i = 6 , Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 So, output array is [-1, -1, -1, 1, 2, 3].
 
Explanation 2:

 for i <= 1 output should be -1.
 for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
 for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
 for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
 So, output array is [-1, 15, 20, 20].

 
*/

package HeapII;

import java.util.ArrayList;
import java.util.PriorityQueue;

class AthLargestElement {

	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		// list to store kth largest number
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> min = new PriorityQueue<>();
		// one by one adding values to the min heap
		for (int val : B) {

			// if the heap size is less than k , we add to
			// the heap
			if (min.size() < A)
				min.add(val);

			/*
			 * otherwise , first we compare the current value with the min heap TOP value
			 * 
			 * if TOP val > current element , no need to remove TOP , bocause it will be the
			 * largest kth element anyhow
			 * 
			 * else we need to update the kth largest element by removing the top lowest
			 * element
			 */

			else {
				if (val > min.peek()) {
					min.poll();
					min.add(val);
				}
			}

			// if heap size >=k we add
			// kth largest element
			// otherwise -1

			if (min.size() >= A)
				list.add(min.peek());
			else
				list.add(-1);
		}
		return list;
	}

	public static void main(String args[]) {
		AthLargestElement ale = new AthLargestElement();
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(1);
		B.add(2);
		B.add(3);
		B.add(4);
		B.add(5);
		B.add(6);
		ale.solve(4, B);
	}
}
