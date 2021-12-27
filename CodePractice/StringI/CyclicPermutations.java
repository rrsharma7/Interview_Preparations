/**
 Q4. Cyclic Permutations

Problem Description

Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints

1 ≤ length(A) = length(B) ≤ 105



Input Format

First argument is a string A.
Second argument is a string B.



Output Format

Return an integer denoting the required answer.



Example Input

Input 1:

 A = "1001"
 B = "0011"
Input 2:

 A = "111"
 B = "111"


Example Output

Output 1:

 1
Output 2:

 3


Example Explanation

Explanation 1:

 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".  
 There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
Explanation 2:

 All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.


See Expected Output
*/

package StringI;

import java.util.Arrays;

class CyclicPermutations {

	 public int solve(String A, String B) {
	        // append B to B to tackle cyclic permutations 
	        B += B;
	        int n = A.length(), m = B.length();
	        int lps[] = new int[n];
	        computeLPS(lps, A);
	        int i = 0, l = 0, ans = 0;
	        while (i < m - 1) {
	            if (B.charAt(i) == A.charAt(l)) {
	                i++;
	                l++;
	            }
	            if (l == n) {
	                l = lps[l - 1];
	                ans++;
	            } else if (i < m && B.charAt(i) != A.charAt(l)) {
	                if (l > 0) {
	                    l = lps[l - 1];
	                } else {
	                    i++;
	                }
	            }
	        }
	        return ans;
	    }

	    //function used to longest proper suffix array
	    public void computeLPS(int lps[], String s) {
	        int n = s.length();
	        lps[0] = 0;
	        int l = 0, i = 1;
	        while (i < n) {
	            if (s.charAt(i) == s.charAt(l)) {
	                lps[i] = l + 1;
	                i++;
	                l++;
	            } else {
	                if (l > 0) {
	                    l = lps[l - 1];
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	    }

	public static void main(String args[]) {
		CyclicPermutations cp = new CyclicPermutations();
		int x = cp.solve("1001","0011");
		System.out.println(x);
	}
}