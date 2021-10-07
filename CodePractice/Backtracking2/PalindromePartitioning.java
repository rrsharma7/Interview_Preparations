/**Palindrome Partitioning
	Problem Description
	Given a string A, partition A such that every string of the partition is a palindrome.
	Return all possible palindrome partitioning of A.
	Ordering the results in the answer : Entry i will come before Entry j if :
	len(Entryi[0]) < len(Entryj[0]) OR
	(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
	(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
	
	Problem Constraints
	1 <= len(A) <= 15	
	Input Format
	First argument is a string A of lowercase characters.	
	Output Format
	Return a list of all possible palindrome partitioning of s.
	Example Input
	Input 1:
	
	A = "aab"
	Input 2:
	
	A = "a"
	
	Example Output
	Output 1:
	
	 [
	    ["a","a","b"]
	    ["aa","b"],
	  ]
	Output 2:
	
	 [
	    ["a"]
	  ]
	
	
	Example Explanation
	Explanation 1:
	
	In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
	Explanation 2:
	
	In the given example, only partition possible is "a" . */
package Backtracking2;

import java.util.ArrayList;

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		callPalindromePartition(s, new ArrayList<>(), result);
		return result;

	}
	private void callPalindromePartition(String s, ArrayList<String> currList, ArrayList<ArrayList<String>> result) {
		if (s.isEmpty())
			result.add(currList);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (isPalindrome(left)) {
				ArrayList<String> copyList = new ArrayList<>(currList);
				copyList.add(left);
				callPalindromePartition(right, copyList, result);
			}
		}

	}
	private boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] s) {
		PalindromePartitioning pp = new PalindromePartitioning();
		pp.partition("aab");

	}
}
