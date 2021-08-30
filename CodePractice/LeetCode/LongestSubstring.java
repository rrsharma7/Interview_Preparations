package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		 int left = 0, length = 0;
			Set<Character> seen = new HashSet();
	        char currentChar;
	        for(int right = 0; right < s.length(); right++) {
	            currentChar = s.charAt(right);
	            while(seen.contains(currentChar)) 
	            	seen.remove(s.charAt(left++));
	            seen.add(currentChar);
	            length = Math.max(length, right - left + 1);
	        }
	        
	        return length;
	}

	public static void main(String[] args) {
		LongestSubstring longestSubstring = new LongestSubstring();
		int ans = longestSubstring.lengthOfLongestSubstring("aab");
		System.out.println("ans=" + ans);

	}

}
