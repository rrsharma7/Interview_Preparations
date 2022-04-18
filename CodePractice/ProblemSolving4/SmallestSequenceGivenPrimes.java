package ProblemSolving4;

import java.util.ArrayList;

public class SmallestSequenceGivenPrimes {

	public ArrayList<Integer> solve(int A, int B, int C, int D) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		int a, b, c;
		a = b = c = 0;
		for (int i = 0; i < D; i++) {
			int minA = res.get(a) * A;
			int minB = res.get(b) * B;
			int minC = res.get(c) * C;
			int min = minA;
			min = Math.min(min, minB);
			min = Math.min(min, minC);
			res.add(min);
			if (min == minA)
				a++;
			if (min == minB)
				b++;
			if (min == minC)
				c++;
		}
		res.remove(0);
		return res;
	}

	public static void main(String[] s) {
		SmallestSequenceGivenPrimes ss = new SmallestSequenceGivenPrimes();
		ss.solve(2, 3, 5, 5);

	}
}
