package ProblemSolving4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatNumber {

	public int repeatedNumber(final List<Integer> a) {
		int index = -1;
		int maxCount = 0;

		if (a.isEmpty()) {
			return -1;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : a) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
			if (map.get(i) > maxCount) {
				maxCount = map.get(i);
				index = i;
			}
		}
		return (maxCount > (a.size() / 3)) ? index : -1;
	}

	public static void main(String[] s) {
		RepeatNumber ss = new RepeatNumber();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(1);
		int res = ss.repeatedNumber(list);
		System.out.println(res);

	}
}
