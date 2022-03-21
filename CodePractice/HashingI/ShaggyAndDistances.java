/**
Shaggy and distances
Problem Description

Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array as a special pair if elements at that index in the array are equal.

Shaggy wants you to find a special pair such that distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.



Problem Constraints
1 <= |A| <= 105



Input Format
First and only argument is the array A.



Output Format
Return one integer corresponding to the minimum possible distance between a special pair.



Example Input
Input 1:

A = [7, 1, 3, 4, 1, 7]
Input 2:

A = [1, 1]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3. 
Explanation 2:

Only possibility is choosing A[1] and A[2].
*/

package HashingI;

import java.util.ArrayList;
import java.util.HashMap;

class ShaggyAndDistances {

	public int solve(ArrayList<Integer> A) {
		HashMap<Integer, Integer> hsMap = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			if (hsMap.containsKey(A.get(i))) {
				int currentIndex = i;
				int previousIndex = hsMap.get(A.get(i));
				min = Math.min((currentIndex - previousIndex), min);
			}
			hsMap.put(A.get(i), i);
		}

		return (min == Integer.MAX_VALUE ? -1 : min);

	}

	public static void main(String args[]) {
		ShaggyAndDistances sad = new ShaggyAndDistances();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(7);
		int x = sad.solve(list);
		System.out.println(x);

	}
}