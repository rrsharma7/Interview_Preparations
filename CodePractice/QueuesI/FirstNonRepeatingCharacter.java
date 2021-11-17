/**
Q3. First non-repeating character

Problem Description

Given a string A denoting a stream of lowercase alphabets.

You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.



Problem Constraints

1 <= |A| <= 100000



Input Format

The only argument given is string A.



Output Format

Return a string B after processing the stream of lowercase alphabets A.



Example Input

Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output

Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation

Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
*/

package QueuesI;

import java.util.LinkedList;
import java.util.Queue;

class FirstNonRepeatingCharacter {

	public String solve(String A) {
		int cnt[] = new int[26];
		Queue<Character> q = new LinkedList<>();
		int n = A.length();
		char ans[] = new char[n];
		for (int i = 0; i < n; i++) {
			char c = A.charAt(i);
			cnt[c - 'a']++;
			if (cnt[c - 'a'] == 1)
				q.add(c);
			while (!q.isEmpty() && cnt[q.peek() - 'a'] > 1)
				q.poll();
			if (q.isEmpty())
				ans[i] = '#';
			else
				ans[i] = q.peek();
		}
		return new String(ans);
	}

	public static void main(String args[]) {
		FirstNonRepeatingCharacter pn = new FirstNonRepeatingCharacter();
		String res = pn.solve("abadbc");
		System.out.println(res);

	}
}
