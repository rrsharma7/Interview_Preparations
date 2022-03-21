/**
Problem Description

Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.



Problem Constraints
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return the array A after sorting as described.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:

A = [5, 17, 100, 11]
B = [1, 100]


Example Output
Output 1:

[5, 4, 2, 1, 3]
Output 2:

[100, 5, 11, 17]


Example Explanation
Explanation 1:

 Simply sort as described.
Explanation 2:

 Simply sort as described.


*/

package HashingI;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

class SortArrayInGivenOrder {

	public ArrayList < Integer > solve(ArrayList < Integer > A, ArrayList < Integer > B) {
        TreeMap < Integer, Integer > mp = new TreeMap < Integer, Integer > ();
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.get(x) == null) {
                mp.put(x, 1);
            } else {
                mp.put(x, mp.get(x) + 1);
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < B.size(); i++) {
            int y = B.get(i);
            if (mp.get(y) != null) {
                while (mp.get(y) > 0) {
                    ans.add(y);
                    mp.put(y, mp.get(y) - 1);
                }
            }
        }
        Set < Integer > keys = mp.keySet();
        for (Integer key: keys) {
            int t = mp.get(key);
            while (t > 0) {
                ans.add(key);
                t--;
            }
        }
        return ans;
    }
	public static void main(String args[]) {
		SortArrayInGivenOrder sago = new SortArrayInGivenOrder();
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);
		A.add(17);
		A.add(100);
		A.add(11);
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(1);
		B.add(100);
		ArrayList<Integer> list = sago.solve(A, B);
		list.stream().forEach(System.out::println);

	}
}
