/**
 Q5. Period of a string

Problem Description

Given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.



Problem Constraints

1 <= N <= 106



Input Format

First and only argument is a string A of length N.



Output Format

Return an integer, denoting the period of the string.



Example Input

Input 1:

 A = "abababab"
Input 2:

 A = "aaaa"


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 Period of the string will be 2: 
 Since, for all i, A[i] = A[i%2]. 
Explanation 2:

 Period of the string will be 1.
*/

package StringI;
import java.util.ArrayList;
class PeriodOfAString {

	 public int solve(String A) {
	        ArrayList <Integer> Z = getZarr(A);
	        int n = A.length();
	        for (int i = 1; i < n; i++) {
	            if (i + Z.get(i) == n) {
	                return i;
	            }
	        }
	        return n;
	    }
	    public ArrayList <Integer> getZarr(String str) {
	        int n = str.length();
	        // Z array
	        ArrayList <Integer> Z = new ArrayList <Integer> ();
	        for (int i = 0; i < n; i++) Z.add(0);
	        int L, R, k;
	        // [L,R] make a window which matches with prefix of s
	        L = R = 0;
	        for (int i = 1; i < n; ++i) {
	            // if i>R nothing matches so we will calculate.
	            // Z[i] using naive way.
	            if (i > R) {
	                L = R = i;
	                // R-L = 0 in starting, so it will start
	                // checking from 0'th index. For example,
	                // for "ababab" and i = 1, the value of R
	                // remains 0 and Z[i] becomes 0. For string
	                // "aaaaaa" and i = 1, Z[i] and R become 5
	                while (R < n && str.charAt(R - L) == str.charAt(R))
	                    R++;
	                Z.set(i, R - L);
	                R--;
	            } else {
	                // k = i-L so k corresponds to number which
	                // matches in [L,R] interval.
	                k = i - L;
	                // if Z[k] is less than remaining interval
	                // then Z[i] will be equal to Z[k].
	                // For example, str = "ababab", i = 3, R = 5
	                // and L = 2
	                if (Z.get(k) < R - i + 1)
	                    Z.set(i, Z.get(k));
	                // For example str = "aaaaaa" and i = 2, R is 5,
	                // L is 0
	                else {
	                    // else start from R and check manually
	                    L = i;
	                    while (R < n && str.charAt(R - L) == str.charAt(R))
	                        R++;
	                    Z.set(i, R - L);
	                    R--;
	                }
	            }
	        }
	        return Z;
	    }

	public static void main(String args[]) {
		PeriodOfAString poas = new PeriodOfAString();
		int x = poas.solve("abababab");
		System.out.println(x);
	}
}