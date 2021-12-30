/**
Q3. Minimum largest element
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add original value(value stored at index before we did any operations) to it's current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimised. Find the minimum possible largest element after B operations.



Problem Constraints

1 <= N <= 106
0 <= B <= 105
-105 <= A[i] <= 105



Input Format

First argument is an integer array A.
Second argument is an integer B.



Output Format

Return an integer denoting the minimum possible largest element after B operations.



Example Input

Input 1:

 A = [1, 2, 3, 4] 
 B = 3
Input 2:

 A = [5, 1, 4, 2] 
 B = 5


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.
 
*/

package HeapII;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class MinimumLargestElement {
	public int solve(int[] A, int B) {
		PriorityQueue<Pair> pq = new PriorityQueue(new CustomComp());
		int s = A.length;
		int[] state = new int[s];
		for (int i = 0; i < s; i++)
			state[i] = A[i];
		for (int i = 0; i < s; i++)
			pq.offer(new Pair(2 * A[i], i));
		for (; B > 0; B--) {
			Pair top = pq.poll();

			// Pick the top element, and change the state of that element, in the state
			// array.
			state[top.ss] = top.ff;
			pq.offer(new Pair(A[top.ss] + top.ff, top.ss));
		}
		int mx = state[0];
		for (int i = 0; i < s; i++)
			mx = Math.max(mx, state[i]);
		return mx;
	}


 static class Pair {
	int ff;
	int ss;

	public Pair(int c, int d) {
		this.ff = c;
		this.ss = d;
	}
 }
	static class CustomComp implements Comparator<Pair> {
		@Override
		public int compare(Pair a, Pair b) {
			return a.ff - b.ff;
		}
	}
		public static void main(String args[]) {
			MinimumLargestElement kpa = new MinimumLargestElement();
			int a[] = { 1, 2, 3, 4 };
			int x=kpa.solve(a, 3);
			System.out.println(x);
		}
	}
