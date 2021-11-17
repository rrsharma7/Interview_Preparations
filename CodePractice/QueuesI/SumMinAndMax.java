/**
Q3. Sum of min and max

Problem Description

Given an array A of both positive and negative integers.

Your task is to compute sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints

1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format

The first argument denotes the integer array A.
The second argument denotes the value B



Output Format

Return an integer that denotes the required value.



Example Input

Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output

Output 1:

 18
Output 2:

 3


Example Explanation

Explanation 1:

 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:

 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 

*/

package QueuesI;

import java.util.ArrayDeque;
import java.util.Deque;

class SumMinAndMax {

	
	    public int solve(int[] A, int B) {
	        int mod = 1000 * 1000 * 1000 + 7;
			Deque < Integer > minn = new ArrayDeque < Integer > ();
	        Deque < Integer > maxx = new ArrayDeque < Integer > ();
	        int i = 0;
	        for (; i < B; i++) {
	            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
	                minn.removeLast();
	            }
	            minn.addLast(i);
	            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
	                maxx.removeLast();
	            }
	            maxx.addLast(i);
	        }
	        long sum = A[minn.getFirst()] + A[maxx.getFirst()];
	        while (i < A.length) {
	            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
	                minn.removeLast();
	            }
	            minn.addLast(i);
	            while (i - minn.getFirst() >= B) {
	                minn.removeFirst();
	            }
	            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
	                maxx.removeLast();
	            }
	            maxx.addLast(i);
	            while (i - maxx.getFirst() >= B) {
	                maxx.removeFirst();
	            }
	            sum += A[maxx.getFirst()] + A[minn.getFirst()];
	            sum %= mod;
	            i++;
	        }
	        sum += mod;
	        sum %= mod;
	        return (int) sum;
	    }
	

	public static void main(String args[]) {
		SumMinAndMax rs = new SumMinAndMax();
		int A[] = {2, 5, -1, 7, -3, -1, -2};
		int sum = rs.solve(A, 4);
		System.out.println(sum);

	}
}
