/**
 Merge Two Sorted Arrays
Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i],B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2 ,11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.
*/

package Sorting1;

import java.util.ArrayList;
import java.util.List;

class MergeTwoSortedArrays {

	public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> res = new ArrayList<Integer>(A.size() + B.size());
		int i = 0;
		int j = 0;
		int m = A.size();
		int n = B.size();
		while (i < m && j < n) {
			if (A.get(i) < B.get(j)) {
				res.add(A.get(i));
				i++;
			} else if (A.get(i) >= B.get(j)) {
				res.add(B.get(j));
				j++;
			}
		}
		while (i < m) {
			res.add(A.get(i));
			i++;

		}
		while (j < n) {
			res.add(B.get(j));
			j++;
		}
		return res;
	}

	public static void main(String args[]) {
		MergeTwoSortedArrays mtsa = new MergeTwoSortedArrays();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(7);
		list1.add(9);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(11);
		list2.add(19);
		ArrayList<Integer> resList = mtsa.solve(list1, list2);
		resList.forEach(System.out::println);
	}
}
