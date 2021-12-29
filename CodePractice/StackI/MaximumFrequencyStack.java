/**
 Q4. Maximum Frequency stack

Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints

1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the array of integers denoting answer to each operation.



Example Input

Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output

Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation

Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations

*/

package StackI;

import java.util.HashMap;
import java.util.*;

class MaximumFrequencyStack {

	// to store frequence of an element in the stack.
	  private HashMap < Integer, Stack < Integer >> stacks = new HashMap < Integer, Stack < Integer >> ();

	  // to maintain the structure of stack and pop out top most element in case of a tie. 
	  private HashMap < Integer, Integer > freq = new HashMap < Integer, Integer > ();

	  private int maxfreq = 0;
	  public ArrayList < Integer > solve(ArrayList < ArrayList < Integer >> A) {

	    ArrayList < Integer > ans = new ArrayList < Integer > ();
	    for (int i = 0; i < A.size(); i++) {
	      int oper = A.get(i).get(0);
	      //push operation
	      if (oper == 1) {
	        int x = A.get(i).get(1);
	        if (freq.get(x) == null) {
	          freq.put(x, 1);
	        } else {
	          freq.put(x, freq.get(x) + 1);
	        }

	        int fr = freq.get(x);
	        maxfreq = Math.max(fr, maxfreq);
	        if (stacks.get(fr) != null) {
	          Stack < Integer > tmp = stacks.get(fr);
	          tmp.push(x);
	        } else {
	          Stack < Integer > tmp = new Stack < Integer > ();
	          tmp.push(x);
	          stacks.put(fr, tmp);
	        }
	        ans.add(-1);
	      } else {
	        //pop operation
	        Stack < Integer > tmp = stacks.get(maxfreq);
	        int x = tmp.peek();
	        ans.add(x);
	        freq.put(x, maxfreq - 1);
	        tmp.pop();
	        if (tmp.empty()) maxfreq--;
	      }
	    }
	    return ans;
	  }
	public static void main(String args[]) {
		MaximumFrequencyStack ms = new MaximumFrequencyStack();
		ArrayList<ArrayList<Integer>> fa = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(5);
		fa.add(al);
		al = new ArrayList<Integer>();
		al.add(2);
		al.add(0);
		fa.add(al);
		al = new ArrayList<Integer>();
		al.add(1);
		al.add(4);
		fa.add(al);
		ArrayList<Integer> ans=ms.solve(fa);
		ans.forEach(System.out::println);
	}
}