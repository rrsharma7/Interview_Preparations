package test;

import java.util.ArrayList;

public class Test4 {

	public ArrayList<ArrayList<Integer>> solve(int A) {
		ArrayList<ArrayList<Integer>> group = new ArrayList<>();
		for (int i = 1; i <= A; i++) {
			ArrayList<Integer> arrli = new ArrayList<Integer>();
			for (int j = 1; j <= A; j++) {
				if (j <= i) {
					arrli.add(j);
				} else {
					arrli.add(0);
				}
			}
			group.add(arrli);
		}

		return group;
	}

	public static void main(String[] args) {
		Test4 test4 = new Test4();
		test4.solve(2);
	}

}
