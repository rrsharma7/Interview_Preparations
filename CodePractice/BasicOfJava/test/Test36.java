package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test36 {

	public String solve(ArrayList<Integer> A) {
		Map<Integer, Integer> mp = new HashMap<>();
		for (int a : A) {
			if (mp.containsKey(a) == false)
				mp.put(a, 1);
			else
				mp.replace(a, mp.get(a) + 1);
		}
		if (mp.size() != 2)
			return "LOSE";
		else {
			int c1 = 0;
			int c2 = 0;
			int a = A.get(0);
			for (int ele : A) {
				if (ele == a)
					c1++;
				else
					c2++;
			}
			if (c1 == c2)
				return "WIN";
		}
		return "LOSE";
	}

	public static void main(String[] args) {
		Test36 test26 = new Test36();
		ArrayList<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(1);
		test.add(2);
		test.add(2);
		//test.add(3);
		test26.solve(test);
	}
}
