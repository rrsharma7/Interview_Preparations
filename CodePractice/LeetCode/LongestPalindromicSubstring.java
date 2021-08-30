package leetcode;

public class LongestPalindromicSubstring {


	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int odd = expand(s, i, i);
			int even = expand(s, i, i + 1);
			int len = Math.max(odd, even);
			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	public int expand(String s, int left, int right) {
		if (s == null || left > right)
			return 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String ans = lps.longestPalindrome("babad");
		System.out.println("ans=" + ans);

	}

}
