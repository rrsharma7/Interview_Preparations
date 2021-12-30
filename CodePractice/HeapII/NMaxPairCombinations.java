/**
Q2. N max pair combinations

Problem Description

Given two integers arrays A and B of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.



Problem Constraints

1 <= N <= 2 * 105

-1000 <= A[i], B[i] <= 1000



Input Format

First argument is an integer array A.
Second argument is an integer array B.



Output Format

Return an intger array denoting the N maximum element in descending order.



Example Input

Input 1:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
Input 2:

 A = [2, 4, 1, 1]
 B = [-2, -3, 2, 4]


Example Output

Output 1:

 [10, 9, 9, 8]
Output 2:

 [8, 6, 6, 5]


Example Explanation

Explanation 1:

 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
Explanation 2:

 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
 
*/

package HeapII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class NMaxPairCombinations {

	 public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
         ArrayList<Integer> result=new ArrayList<>();
         Collections.sort(A,Collections.reverseOrder());
         Collections.sort(B,Collections.reverseOrder());
         PriorityQueue<Integer> pq=new PriorityQueue<>();
         for(int a:A){
             for(int b:B){
                 if(pq.size()<A.size()) pq.add(a+b);
                 else if(a+b>pq.peek()) pq.add(a+b);
                 else break;
                 if(pq.size()>A.size()) pq.remove();
             }
         }
        while(pq.size()>0) result.add(0,pq.poll());
        return result;
    }

	public static void main(String args[]) {
		NMaxPairCombinations npc = new NMaxPairCombinations();
		ArrayList<Integer> list1=new ArrayList<>();
		list1.add(1);
		list1.add(4);
		list1.add(2);
		list1.add(3);
		ArrayList<Integer> list2=new ArrayList<>();
		list2.add(2);
		list2.add(5);
		list2.add(1);
		list2.add(6);
		npc.solve(list1, list2);
	}
}
