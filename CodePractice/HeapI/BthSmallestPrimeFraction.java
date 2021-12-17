/**
Q1. B Closest Points to Origin

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
 
*/

package HeapI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class BthSmallestPrimeFraction {
	   public int[] solve(int[] A, int B) {
	        int K = B;
	        PriorityQueue < Pair > q = new PriorityQueue < Pair > (new CustomComp());
	        Map < Integer, Integer > nxt = new HashMap < Integer, Integer > ();
	        for (int i = A.length - 1; i > 0; i--) {
	            if (nxt.containsKey(A[i]) == true)
	                nxt.replace(A[i], A[i - 1]);
	            else
	                nxt.put(A[i], A[i - 1]);
	        }

	        double last = (double) A[A.length - 1];
	        double d;
	        if (nxt.containsKey(1) == true)
	            nxt.replace(1, 0);
	        else
	            nxt.put(1, 0);

	        for (int i = 0; i < A.length; i++) {
	            d = (double) A[i] / last;
	            q.offer(new Pair(d, A[i], (int) last));
	        }

	        while (q.size() > 0 && K > 0) {
	            K--;
	            if (K == 0) break;
	            Pair p = q.poll();
	            if (nxt.containsKey(p.tt) == true && nxt.get(p.tt) != 0) {
	                p.tt = nxt.get(p.tt);
	                d = (double) p.ss / (double) p.tt;
	                q.offer(new Pair(d, p.ss, p.tt));
	            }
	        }
	        int[] ret = new int[2];
	        ret[0] = q.peek().ss;
	        ret[1] = q.peek().tt;

	        return ret;
	    }
	
	//class and comparator for pairs
	static class Pair {
	    double ff;
	    int ss;
	    int tt;
	    public Pair(double c, int d, int e) {
	        this.ff = c;
	        this.ss = d;
	        this.tt = e;
	    }
	}
	static class CustomComp implements Comparator < Pair > {
	    @Override
	    public int compare(Pair a, Pair b) {
	        if (a.ff > b.ff)
	            return 1;
	        return -1;
	    }
	}
	public static void main(String args[]) {
		BthSmallestPrimeFraction p3 = new BthSmallestPrimeFraction();
		int a[]= {1, 2, 3, 5};
		p3.solve(a, 3);

	}
}
