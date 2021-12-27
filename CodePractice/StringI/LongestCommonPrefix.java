/**
 Q1. Longest Common Prefix
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints

0 <= sum of length of all strings <= 1000000



Input Format

The only argument given is an array of strings A.



Output Format

Return the longest common prefix of all strings in A.



Example Input

Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output

Output 1:

"a"
Output 2:

"ab"


Example Explanation

Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".

*/

package StringI;

import java.util.Arrays;

class LongestCommonPrefix {

	 public String longestCommonPrefix(String[] a) {
	        int size = a.length;
	        if (size == 0)
	            return "";
	 
	        if (size == 1)
	            return a[0];
	        Arrays.sort(a);
	        int end = Math.min(a[0].length(), a[size-1].length());
	        int i = 0;
	        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
	            i++;
	 
	        String pre = a[0].substring(0, i);
	        return pre;
	    }
		
	public static void main(String args[]) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String a[]={"abcdefgh", "aefghijk", "abcefgh"};
		String x=lcp.longestCommonPrefix(a);
		System.out.println(x);
	}
}