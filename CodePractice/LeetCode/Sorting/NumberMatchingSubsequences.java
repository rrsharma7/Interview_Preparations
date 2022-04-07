package Leetcode.Sorting;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class NumberMatchingSubsequences {

	public int numMatchingSubseq(String S, String[] words) {
		int res = 0;
		Map<Character, Queue<String>> map = new HashMap<>();
		for (char c : S.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, new LinkedList<>());
			}
		}
		for (String word : words) {
			if (word.length() > S.length())
				continue;

			if (map.containsKey(word.charAt(0))) {
				map.get(word.charAt(0)).add(word);
			}
		}

		for (char c : S.toCharArray()) {
			Queue<String> queue = map.get(c);

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String curWord = queue.remove();

				if (curWord.length() == 1) {
					++res;
				} else if (map.containsKey(curWord.charAt(1))) {
					map.get(curWord.charAt(1)).add(curWord.substring(1));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberMatchingSubsequences nms = new NumberMatchingSubsequences();
		String arr[] = { "a", "bb", "acd", "ace" };
		int ans = nms.numMatchingSubseq("abcde", arr);
		System.out.println(ans);

	}

}
