package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test43 {

	public int solve(ArrayList<Integer> A) {
		Collections.sort(A);
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum += (A.size() - i) * A.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		Test43 test26 = new Test43();
		ArrayList<Integer> test = new ArrayList<>();
		test.add(2);
		test.add(1);
		test.add(3);
		test26.solve(test);

	}
}
