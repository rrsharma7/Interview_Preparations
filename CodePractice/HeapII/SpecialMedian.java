/**
Q4. Special Median

Problem Description

You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
Median is the middle element in the sorted list of elements. If the number of elements are even then median will be (sum of both middle elements)/2.

Return 1 if the array is special else return 0.

NOTE:

For A[0] consider only the median of elements [A[1], A[2], …, A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], …., A[N-2]]


Problem Constraints

1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.



Input Format

First and only argument is an integer array A.



Output Format

Return 1 if the given array is special else return 0.



Example Input

Input 1:

 A = [4, 6, 8, 4]
Input 2:

 A = [2, 7, 3, 1]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explantion 1:

 Here, 6 is equal to the median of [8, 4].
Explanation 2:

 No element satisfies any condition.
 
*/

package HeapII;

import java.util.Comparator;
import java.util.PriorityQueue;

class SpecialMedian {
	static PriorityQueue<Integer> maxHeap;
	static PriorityQueue<Integer> minHeap;

	public int solve(int[] A) {
		int n = A.length;
		minHeap = new PriorityQueue();
		maxHeap = new PriorityQueue(new CustomComp());
		for (int i = 0; i < (n - 1); i++) {
			add_number(A[i]);
			if (A[i + 1] == find_median())
				return 1;
		}
		minHeap = new PriorityQueue();
		maxHeap = new PriorityQueue(new CustomComp());
		for (int i = n - 1; i > 0; i--) {
			add_number(A[i]);
			if (A[i - 1] == find_median())
				return 1;
		}
		return 0;
	}

	public static void add_number(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.peek());
		maxHeap.poll();
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.peek());
			minHeap.poll();
		}
	}

	public static int find_median() {
		if (maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		else {
			int ans = maxHeap.peek() + minHeap.peek();
			if (ans % 2 != 0)
				return Integer.MAX_VALUE; // answer is a fraction
			else
				return ans / 2;
		}
	}

	static class CustomComp implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}

	public static void main(String args[]) {
		SpecialMedian kpa = new SpecialMedian();
		int a[] = { 4, 6, 8, 4 };
		int x = kpa.solve(a);
		System.out.println(x);
	}
}
