package lovebabbar.string;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharactersString {

	public void duplicateCharacters(String str) {
		HashMap<Character, Integer> hmap = new HashMap<>();
		char chArray[] = str.toCharArray();
		for (char ch : chArray) {
			if (hmap.containsKey(ch)) { 
				hmap.put(ch, hmap.get(ch) + 1);
			} else {
				hmap.put(ch, 1);
			}

		}
		for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		DuplicateCharactersString dc = new DuplicateCharactersString();
		dc.duplicateCharacters("geeksforgeeks");

	}

}
