/**
Q5. Running Median

Problem Description

Given an array of integers A denoting a stream of integers. New arrays of integer B and C are formed. Each time an integer is encountered in a stream, append it at the end of B and append median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements are N in B and N is odd then consider medain as B[N/2] ( B must be in sorted order).
If the number of elements are N in B and N is even then consider medain as B[N/2-1]. ( B must be in sorted order).


Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of first i elements.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation

Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 

 
*/

package HeapII;

import java.util.Comparator;
import java.util.PriorityQueue;

class RunningMedian {

	static PriorityQueue < Integer > max_heap;
	  static PriorityQueue < Integer > min_heap;
	  public int[] solve(int[] A) {
	    min_heap = new PriorityQueue();
	    max_heap = new PriorityQueue(new CustomComp());
	    int n = A.length;
	    int[] ans = new int[n];
	    for (int i = 0; i < n; ++i) {
	      add(A[i]);
	      ans[i] = get_median();
	    }

	    return ans;
	  }
	  public static int get_median() {
	    int total = min_heap.size() + max_heap.size();
	    int ret;
	    if (total % 2 == 1) {
	      if (max_heap.size() > min_heap.size())
	        ret = max_heap.peek();
	      else
	        ret = min_heap.peek();
	    } else {
	      ret = Integer.MAX_VALUE;
	      if (max_heap.size() != 0)
	        ret = Math.min(ret, max_heap.peek());
	      if (min_heap.size() != 0)
	        ret = Math.min(ret, min_heap.peek());
	    }
	    return ret;
	  }
	  public static void add(int a) {
	    if (max_heap.size() != 0 && (a >= max_heap.peek()))
	      min_heap.offer(a);
	    else
	      max_heap.offer(a);

	    if (Math.abs(max_heap.size() - min_heap.size()) > 1) {
	      if (max_heap.size() > min_heap.size()) {
	        int temp = max_heap.peek();
	        max_heap.poll();
	        min_heap.offer(temp);
	      } else {
	        int temp = min_heap.peek();
	        min_heap.poll();
	        max_heap.offer(temp);
	      }
	    }
	  }

	
	static class CustomComp implements Comparator < Integer > {
	  @Override
	  public int compare(Integer a, Integer b) {
	    return b - a;
	  }
	public static void main(String args[]) {
		RunningMedian rm = new RunningMedian();
		int a[]= {1, 2, 5, 4, 3};
		rm.solve(a);
	}
	}
}
