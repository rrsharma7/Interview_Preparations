/**
Q1. Ways to form Max Heap

Problem Description

Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes.

Find the number of distinct Max Heap can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.



Problem Constraints

1 <= A <= 100



Input Format

First and only argument is an inetegr A.



Output Format

Return an integer denoting the number of distinct Max Heap.



Example Input

Input 1:

 A = 4
Input 2:

 A = 10


Example Output

Output 1:

 3
Output 2:

 3360


Example Explanation

Explanation 1:

 Let us take 1, 2, 3, 4 as our 4 distinct integers
 Following are the 3 possible max heaps from these 4 numbers :
      4           4                     4
    /  \         / \                   / \ 
   3    2   ,   2   3      and        3   1
  /            /                     /    
 1            1                     2
Explanation 2:

 Number of distinct heaps possible with 10 distinct integers = 3360.
 
*/

package HeapII;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class WaysToFormMaxHeap {

	private long nCp(int n, int p) {
		long ans = (long) 1;
		for (long i = n; i > (long) (p); i--) {
			ans *= i;
			ans %= 1000000007;
		}
		long denom = 1;
		for (int i = (n - p); i >= 1; i--) {
			denom *= (long) (i);
			denom %= 1000000007;
		}
		ans *= BigInteger.valueOf(denom).modInverse(BigInteger.valueOf(1000000007)).longValue();
		ans %= 1000000007;
		// System.out.println(n+"C"+p+" = "+ans);
		return (ans);
	}

	public int solve(int A) {
		if (A <= 2) {
			return 1;
		}
		int height = (int) (Math.log(A) / Math.log(2)) + 1;
		int A1 = Math.min(A - 1 - ((int) Math.pow(2, (height - 2)) - 1), ((int) Math.pow(2, (height - 1)) - 1));
		int A2 = A - A1 - 1;
		// System.out.println("A="+A+", A1="+A1+", A2="+A2+", height="+height);
		return (int) ((((nCp((A - 1), A1) * (long) solve(A1)) % 1000000007) * (long) solve(A2)) % 1000000007);
	}

	public static void main(String args[]) {
		WaysToFormMaxHeap wtmh = new WaysToFormMaxHeap();
		int x = wtmh.solve(4);
		System.out.println(x);
	}
}
