package problemsolving6;

import java.util.ArrayList;

public class KthRowPascalTriangle {

	public ArrayList<Integer> getRow(int A) {
		ArrayList<Integer> ans = new ArrayList<Integer>(A + 1);
		int line = A + 1;
		int K = 1;
		for (int i = 1; i <= line; i++) {
			ans.add(K);
			K = K * (line - i) / i;		}
		return ans;
	}

	public static void main(String[] s) {
		KthRowPascalTriangle kthrow = new KthRowPascalTriangle();
		kthrow.getRow(3);
	}
}
