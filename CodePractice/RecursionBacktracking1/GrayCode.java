package RecursionBacktracking1;

import java.util.ArrayList;

class GrayCode {

	public ArrayList<Integer> grayCode(int a) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int c = (int) Math.pow(2, a);
		for (int i = 0; i < c; i++) {
			int s = 0;
			s = i ^ (i >> 1);
			l.add(s);
		}
		return l;
	}

	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		System.out.print(grayCode.grayCode(2));
	}
}
