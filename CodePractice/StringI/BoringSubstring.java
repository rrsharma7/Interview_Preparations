/**
 Q3. Boring substring

Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

The only argument given is string A.



Output Format

Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.



Example Input

Input 1:

 A ="abcd"
Input 2:

 A = "aab"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:

 No arrangement of string A can make it free of boring substrings.
*/

package StringI;

import java.util.Arrays;

class BoringSubstring {

	public boolean check(String s) {
        boolean ok = true;
        for (int i = 0; i + 1 < s.length(); ++i)
            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
        return ok;
    }
    public int solve(String A) {
        String odd = "", even = "";
        for (int i = 0; i < A.length(); ++i) {
            char c = A.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        odd = String.valueOf(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        if (check(odd + even))
            return 1;
        else if (check(even + odd))
            return 1;
        return 0;
    }

	public static void main(String args[]) {
		BoringSubstring rs = new BoringSubstring();
		int x = rs.solve("abcd");
		System.out.println(x);
	}
}