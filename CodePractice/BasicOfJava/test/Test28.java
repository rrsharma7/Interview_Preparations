package test;

import java.util.HashMap;

public class Test28 {

	public int solve(String A, String B) {
		int n = A.length();
		int m = B.length();
		int count = 0;
		HashMap<Character, Integer> hsMap1 = new HashMap<>();
		HashMap<Character, Integer> hsMap2 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hsMap1.put(A.charAt(i), hsMap1.getOrDefault(A.charAt(i), 0) + 1);
			hsMap2.put(B.charAt(i), hsMap2.getOrDefault(B.charAt(i), 0) + 1);
		}
		count += compare(hsMap1, hsMap2);
		for (int i = n, j = 0; i < m; i += 1, j += 1) {
			hsMap2.put(B.charAt(i), hsMap2.getOrDefault(B.charAt(i), 0) + 1);
			hsMap2.put(B.charAt(j), hsMap2.getOrDefault(B.charAt(j), 0) - 1);
			count += compare(hsMap1, hsMap2);
		}
		return count;
	}
	

	private int compare(HashMap<Character, Integer> hsMap1, HashMap<Character, Integer> hsMap2) {
		for (int i = 0; i < 26; i += 1) {
			if (hsMap1.getOrDefault((char) (i + 97), 0) != hsMap2.getOrDefault((char) (i + 97), 0))
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		Test28 test9 = new Test28();
		String A = "abc";
		String B = "abcbacabc";
		test9.solve(A, B);
	}

}
