/**
Q4. Magician and Chocolates

Problem Description

Given N bags, each bag contains Bi chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Bi chocolates, then the magician fills the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints

1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105



Input Format

First argument is an integer A.
Second argument is an integer array B of size N.



Output Format

Return an integer denoting the maximum number of chocolates that kid can eat in A units of time.



Example Input

Input 1:

 A = 3
 B = [6, 5]
Input 2:

 A = 5
 b = [2, 4, 6, 8, 10]


Example Output

Output 1:

 14
Output 2:

 33


Example Explanation

Explanation 1:

 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
Explanation 2:

 Maximum number of chocolates that can be eaten is 33.
*/

package HeapI;

import java.util.Collections;
import java.util.PriorityQueue;

class MagicianAndChocolates {
	private final int mod = 1000000007;

	public int nchoc(int A, int[] B) {
		if (A < 1 || B.length == 0)
			return 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < B.length; i++)
			maxHeap.add(B[i]);
		long ans = 0;
		while (A != 0 && maxHeap.peek() != 0) {
			int numChoc = maxHeap.remove();
			ans = (ans + numChoc) % mod;
			maxHeap.add(numChoc / 2);
			A--;
		}

		return (int) (ans % mod);
	}

	public static void main(String args[]) {
		MagicianAndChocolates ms = new MagicianAndChocolates();
		int a[] = {6,5};
		int x = ms.nchoc(3, a);
		System.out.println(x);

	}
}