package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String cur : strs) {
			char[] ch = cur.toCharArray();
			Arrays.sort(ch);
			String sorted = new String(ch);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(cur);
		}
		ans.addAll(map.values());
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams sa = new GroupAnagrams();
		String[] str = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		sa.groupAnagrams(str);

	}

}
