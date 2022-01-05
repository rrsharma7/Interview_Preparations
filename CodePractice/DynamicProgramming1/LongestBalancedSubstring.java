/**
Q3. Longest Balanced Substring

Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string .

Conditions for a string to be balanced :

Blank string is balanced ( However blank string will not be provided as a test case ).
If B is balanced : (B) , [B] and {B} are also balanced.
If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced.


Problem Constraints

0 <= |A| <= 106



Input Format

First and only argument is an string A.



Output Format

Return an single integer denoting the lenght of the longest balanced substring.



Example Input

Input 1:

 A = "[()]"
Input 2:

 A = "[(])"


Example Output

Output 1:

 4
Output 2:

 0


Example Explanation

Explanation 1:

 Substring [1:4] i.e "[()]" is the longest balanced substring of length 4.
Explanation 2:

 None of the substring is balanced so answer is 0.
*/

package DynamicProgramming1;

import java.util.Arrays;
import java.util.Stack;

class LongestBalancedSubstring {

	public int LBSlength(final String A) {
		char[] s = A.toCharArray();
		if (s.length <= 1)
			return 0;
		int curMax = 0;
		int[] longest = new int[s.length];
		Arrays.fill(longest, 0);
		for (int i = 1; i < s.length; i++) {
			if (s[i] == '>' || s[i] == ')' || s[i] == ']' || s[i] == '}') {
				if ((s[i] == '>' && s[i - 1] == '<') || (s[i] == ')' && s[i - 1] == '(')
						|| (s[i] == ']' && s[i - 1] == '[') || (s[i] == '}' && s[i - 1] == '{')) {
					longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
					curMax = Math.max(longest[i], curMax);
				} else {
					if (i - longest[i - 1] - 1 >= 0 && ((s[i] == '>' && s[i - longest[i - 1] - 1] == '<')
							|| (s[i] == ')' && s[i - longest[i - 1] - 1] == '(')
							|| (s[i] == ']' && s[i - longest[i - 1] - 1] == '[')
							|| (s[i] == '}' && s[i - longest[i - 1] - 1] == '{'))) {
						longest[i] = longest[i - 1] + 2
								+ ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
						curMax = Math.max(longest[i], curMax);
					}
				}
			}
			// if s[i] == '<' or '(' or '[' or '{', skip it, because longest[i] must be 0
		}
		return curMax;
	}

	public static void main(String[] args) {
		LongestBalancedSubstring lbs = new LongestBalancedSubstring();
		int ans = lbs.LBSlength("[()]");
		System.out.println(ans);
	}

}