package lovebabbar.string;

public class LongestPalindrome {

	public static String longestPalin(String S) {
		int n = S.length();
		char[] c = S.toCharArray();
		Boolean[][] dp = new Boolean[n][n];
		int start, end;
		start = end = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (j - i < 3) { // base case
					dp[i][j] = (c[i] == c[j]);
				} else {
					dp[i][j] = (c[i] == c[j] && dp[i + 1][j - 1]);
				}

				if (dp[i][j] && (end - start <= j - i)) {
					start = i;
					end = j;
				}
			}
		}
		return S.substring(start, end + 1);
	}

	public static void main(String[] args) {
		String longestPalin = longestPalin("cbabd");
		System.out.println("longestPalin=" + longestPalin);
	}
}
// caabbabd - even --> abba
//cbabd - odd --> abba