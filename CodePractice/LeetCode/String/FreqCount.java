package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class FreqCount {
	
	public String getLargestString(String s) {

		String res = "";
		int[] frequency_array = new int[26];
		for (int i = 0; i < s.length(); i++) {
			frequency_array[s.charAt(i) - 'a']++;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		return res;
	}

	public static void main(String[] args) 
	{
		FreqCount fc = new FreqCount();
		fc.getLargestString("axxzzx");
	}
}
