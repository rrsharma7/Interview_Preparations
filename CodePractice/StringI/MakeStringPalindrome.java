/**
 Q3. Make String Pallindrome

Problem Description

Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints

1 <= N <= 106



Input Format

The only argument given is a string A.



Output Format

Return an integer denoting the minimum characters that are needed to be inserted to make the string a palindrome string.



Example Input

Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output

Output 1:

 2
Output 2:

 0


Example Explanation

Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome. */

package StringI;

class MakeStringPalindrome {

	public int solve(String A) {
        String s = new String(A);
        StringBuilder sb = new StringBuilder(A);
        s += sb.reverse();
        int lps[];
        lps = computeLPS(s);
        return Math.max(A.length() - lps[s.length() - 1], 0);
    }
    public int[] computeLPS(String s) {
        int l = 0, i = 1;
        int lps[] = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(l)) {
                lps[i] = ++l;
                i++;
            } else {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

	public static void main(String args[]) {
		MakeStringPalindrome msp = new MakeStringPalindrome();
		int x = msp.solve("aab");
		System.out.println(x);
	}
}