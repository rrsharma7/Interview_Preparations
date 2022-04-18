package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test37 {

	public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> hsMap = new HashMap<>();
		if (A.size() == 1) {
			result.add(A.get(0));
			return result;
		}
		for (Integer a : A) {
			if (hsMap.containsKey(a)) {
				hsMap.put(a, hsMap.get(a) + 1);
			} else {
				hsMap.put(a, 1);
			}
		}
		if (hsMap.containsKey(0)) {
			int zeroCount = hsMap.get(0);
			while(zeroCount > 0) {
				result.add(0);
				zeroCount--;
			}
		} if (hsMap.containsKey(1)) {
			int oneCount = hsMap.get(1);
			while(oneCount > 0) {
				result.add(1);
				oneCount--;
			}
		} if (hsMap.containsKey(2)) {
			int twoCount = hsMap.get(2);
			while(twoCount > 0) {
				result.add(2);
				twoCount--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Test37 test26 = new Test37();
		ArrayList<Integer> test = new ArrayList<>();
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(0);
		test.add(1);
		test.add(2);
		test26.sortColors(test);
	}
}
