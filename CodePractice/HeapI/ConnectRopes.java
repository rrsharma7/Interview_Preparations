/**
Q1. Connect ropes

Problem Description

Given an array of integers A representing the length of ropes.

You need to connect these ropes into one rope. The cost of connecting two ropes is equal to the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 1000



Input Format

The only argument given is the integer array A.



Output Format

Return an integer denoting the minimum cost to connect these ropes into one rope.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 33
Output 2:

 182


Example Explanation

Explanation 1:

 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
Explanation 2:

 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
*/

package HeapI;

import java.util.PriorityQueue;

class ConnectRopes {

	public int solve(int[] A) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int cost = 0;
		// insert all elements in the queue
		for (int x : A) {
			pq.offer(x);
		}
		// keep on removing elements from the queue untill there is one element in the
		// queue
		while (pq.size() != 1) {
			// Take the two ropes with smallest length
			int l1 = pq.poll();
			int l2 = pq.poll();
			// cost of combining these two ropes is l1 + l2.
			cost += l1 + l2;

			// add the newly formed rope of length l1 + l2 to the queue.
			pq.offer(l1 + l2);
		}

		return cost;

	}

	public static void main(String args[]) {
		ConnectRopes cr = new ConnectRopes();
		int a[]= {1, 2, 3, 4, 5};
		int x = cr.solve(a);
		System.out.println(x);

	}
}