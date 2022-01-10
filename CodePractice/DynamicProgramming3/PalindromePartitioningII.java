/**
Q3. Palindrome Partitioning II

Problem Description

Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.



Problem Constraints

1 <= length(A) <= 501



Input Format

The first and the only argument contains the string A.



Output Format

Return an integer, representing the minimum cuts needed.



Example Input

Input 1:

 A = "aba"
Input 2:

 A = "aab"


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 "aba" is already a palindrome, so no cuts are needed.
Explanation 2:

 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

package DynamicProgramming3;

class PalindromePartitioningII {

	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int[] minCutUptoI = new int[s.length()]; // minCutUptoI[i] means the minumum cuts needed for a palindrome
													// partitioning of s.substring(0, i+1).

		for (int i = 0; i < s.length(); i++) {
			minCutUptoI[i] = i; // base case -> the maximum cut needed to cut the s.substring(0, i + 1) is i ->
								// in case of no palindromes in substring (remember single char is also a
								// palindrome )
		}

		for (int mid = 0; mid < s.length(); mid++) { // iterate through all chars as mid point of palindrome

			// CASE 1. odd len: center is at index mid, expand on both sides
			for (int start = mid, end = mid; start >= 0 && end < s.length()
					&& s.charAt(start) == s.charAt(end); start--, end++) {
				int minCutUptoEnd = (start == 0) ? 0 : minCutUptoI[start - 1] + 1; // if start has reached 0, means that
																					// s.substring(0, end + 1) is
																					// palindrome and so NO cut is
																					// required (that is why 0)
																					// otherwise CUTS require upto
																					// substring(0, start) and + 1
																					// because of the substring between
																					// start and end needed that 1 cut
				minCutUptoI[end] = Math.min(minCutUptoEnd, minCutUptoI[end]);
			}

			// CASE 2: even len: center is between [mid-1,mid], expand on both sides
			for (int start = mid - 1, end = mid; start >= 0 && end < s.length()
					&& s.charAt(start) == s.charAt(end); start--, end++) {
				int minCutUptoEnd = (start == 0) ? 0 : minCutUptoI[start - 1] + 1;
				minCutUptoI[end] = Math.min(minCutUptoEnd, minCutUptoI[end]);
			}
		}

		return minCutUptoI[s.length() - 1];
	}

	public static void main(String[] args) {
		PalindromePartitioningII pp2 = new PalindromePartitioningII();
		int ans = pp2.minCut("aab");
		System.out.println(ans);
	}

}