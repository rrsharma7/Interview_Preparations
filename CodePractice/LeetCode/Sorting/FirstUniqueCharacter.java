package Leetcode.Sorting;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), -1);
			} else {
				map.put(s.charAt(i), i);
			}
		}
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() != -1) {
				return m.getValue();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacter cd = new FirstUniqueCharacter();
		int ans = cd.firstUniqChar("loveleetcode");
		System.out.println(ans);

	}

}
