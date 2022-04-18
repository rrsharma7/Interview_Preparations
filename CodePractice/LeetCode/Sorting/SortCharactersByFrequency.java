package LeetCode.Sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			queue.add(entry);
		}

		String result = "";

		while (!queue.isEmpty()) {
			Map.Entry<Character, Integer> entry = queue.poll();

			for (int i = 0; i < entry.getValue(); i++) {
				result = result + entry.getKey();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SortCharactersByFrequency scbf = new SortCharactersByFrequency();
		String ans = scbf.frequencySort("tree");
		System.out.println(ans);

	}

}
