package test;

import java.util.HashMap;

public class Test31 {

	public int solve(int[] A) {
		int n = A.length;
		long sum=0;
		HashMap <Long,Long> mp = new HashMap <Long, Long>();
		for (int i = 0; i < n; ++i) {
			sum = sum + A[i];
			if (sum == 0 || mp.get(sum)!=null)
				return 1;
			else 
				mp.put(sum, new Long(1));
		}
		return 0;
	}

	public static void main(String[] args) {
		Test31 test26 = new Test31();
		int A[] = { 4,1,-3,1,-3 };
		int x = test26.solve(A);
		System.out.println("x=" + x);
	}

}
