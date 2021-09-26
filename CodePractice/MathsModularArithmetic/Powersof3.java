package MathsModularArithmetic;

import java.util.ArrayList;

public class Powersof3 {

	public ArrayList<Integer> solve(int A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int pow = 1;
		while (A > 0) {
			int times = A % 3;
			while (times > 0) {
				ans.add(pow);
				times--;
			}
			pow *= 3;
			A /= 3;
		}
		return ans;
	}

	public static void main(String[] args) {
		Powersof3 po3 = new Powersof3();
		po3.solve(13);

	}
}
