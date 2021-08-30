package test;

import java.util.Arrays;

public class Test45 {

	 public String largestNumber(final int[] A) {
	        String str[] = new String[A.length];
			for (int i = 0; i < A.length; i++) {
				str[i] = Integer.toString(A[i]);
			}
			Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
			String s = "";
			if (str[0].equals("0"))
				return "0";
			for (int i = 0; i < A.length; i++)
				s += str[i];
			return s;
	    }

	public static void main(String[] args) {
		Test45 test45 = new Test45();
		int a[] = { 3, 30, 34, 5, 9};
		test45.largestNumber(a);

	}
}

