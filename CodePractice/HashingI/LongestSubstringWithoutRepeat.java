/**
Q4. Problem Description

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.


*/

package HashingI;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {
		int left = 0, right = 0, max = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (right < A.length()) {
			String t = "" + A.charAt(right);
			if (!map.containsKey(t)) {
				map.put(t, 1);
				max = Math.max(right - left + 1, max);
				right++;
			} else {
				map.remove("" + A.charAt(left));
				left++;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		LongestSubstringWithoutRepeat sad = new LongestSubstringWithoutRepeat();
		int x = sad.lengthOfLongestSubstring("abcabcbb");
		System.out.println(x);

	}
}