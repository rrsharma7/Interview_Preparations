/**
 * B Closest Points to Origin
Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 * 
 */

package Sorting2;

import java.util.PriorityQueue;

class BClosestPointsOrigin {

	public int[][] solve(int[][] A, int B) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> getDistance(p1).compareTo(getDistance(p2)));
		for (int i = 0; i < A.length; i++) {
			pq.add(A[i]);
		}
		int[][] result = new int[B][2];
		for (int i = 0; i < B; i++) {
			result[i] = pq.remove();
		}

		return result;
	}

	private Double getDistance(int[] point) {
		return Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
	}

	public static void main(String[] args) {
		BClosestPointsOrigin bcpo = new BClosestPointsOrigin();
		int arr[][] = { { 1, -1 }, { -2, -1 } };
		bcpo.solve(arr, 1);
	}
}
