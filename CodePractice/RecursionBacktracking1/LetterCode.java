/**
Letter Phone
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints
1 <= |A| <= 10



Input Format
The only argument is a digit string A.



Output Format
Return a string array denoting the possible letter combinations.



Example Input
Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output
Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation
Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations. */
package RecursionBacktracking1;

import java.util.ArrayList;
import java.util.HashMap;

class LetterCode {

	public ArrayList<String> letterCombinations(String a) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("2", "abc");
		map.put("3", "def");
		map.put("9", "wxyz");
		map.put("0", "0");
		map.put("1", "1");
		ArrayList<String> result = new ArrayList<String>();
		if (a == null || a.length() == 0) {
			return result;
		}
		ArrayList<Character> temp = new ArrayList<Character>();
		getString(a, temp, result, map);
		return result;
	}

	public void getString(String a, ArrayList<Character> temp, ArrayList<String> res, HashMap<String, String> map) {
		if (a.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				arr[i] = temp.get(i);
			}
			res.add(String.valueOf(arr));
			return;
		}
		String num = a.substring(0, 1);
		String let = map.get(num);
		for (int i = 0; i < let.length(); i++) {
			temp.add(let.charAt(i));
			getString(a.substring(1), temp, res, map);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		LetterCode lc = new LetterCode();
		System.out.print(lc.letterCombinations("23"));
	}
}
