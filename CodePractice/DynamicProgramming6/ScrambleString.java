/**
Q4. Scramble String

Problem Description

Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings A and B of the same length, determine if B is a scrambled string of S.



Problem Constraints

1 <= len(A), len(B) <= 50



Input Format

The first argument of input contains a string A.

The second argument of input contains a string B.



Output Format

Return 1 if true, 0 if false



Example Input

Input 1:

 A = "we"
 B = "we"
Input 2:

 A = "phqtrnilf"
 B = "ilthnqrpf"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 
It is the same string.


Explanation 2:

 There is no way to achieve B from A.
*/

package DynamicProgramming6;

import java.util.*;

class ScrambleString {

	public int isScramble(final String s1, final String s2) {
		if (s1.length() != s2.length())
			return 0;

		if (s1.length() == 0 || s1.equals(s2))
			return 1;

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if (!new String(arr1).equals(new String(arr2))) {
			return 0;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, s1.length());
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, s2.length());
			String s23 = s2.substring(0, s2.length() - i);
			String s24 = s2.substring(s2.length() - i, s2.length());

			if (isScramble(s11, s21) == 1 && isScramble(s12, s22) == 1)
				return 1;
			if (isScramble(s11, s24) == 1 && isScramble(s12, s23) == 1)
				return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		int x = ss.isScramble("phqtrnilf","ilthnqrpf");
		System.out.println(x);

	}

}