/**
Q1. Word Break

Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.

Input Format:

The first argument is a string, A.
The second argument is an array of strings, B.
Output Format:

Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
Constraints:

1 <= len(A) <= 6500
1 <= len(B) <= 10000
1 <= len(B[i]) <= 20
Examples:

Input 1:
    A = "myinterviewtrainer",
    B = ["trainer", "my", "interview"]

Output 1:
    1

Explanation 1:
    Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Input 2:
    A = "a"
    B = ["aaa"]

Output 2:
    0

Explanation 2:
    Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
*/

package DynamicProgramming5;

import java.util.ArrayList;
import java.util.HashMap;

class WordBreak {

	HashMap<String, Integer> map = new HashMap<>();

	public int wordBreak(String A, ArrayList<String> B) {
		if (A == null || A.length() == 0)
			return 0;
		return dfs(A, B);
	}

	int dfs(String A, ArrayList<String> B) {
		if (A.length() == 0)
			return 1;
		if (map.containsKey(A))
			return 0;
		for (String s1 : B) {
			if (A.startsWith(s1)) {
				int str = dfs(A.substring(s1.length()), B);
				if (str == 1)
					return 1;
			}
		}
		map.put(A, 0);
		return 0;
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("trainer");
		strList.add("my");
		strList.add("interview");
		int ans = wb.wordBreak("myinterviewtrainer", strList);
		System.out.println(ans);
	}

}