package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test39 {

//	Approach 1
//	public int solve(ArrayList<Integer> A) {
//		Collections.sort(A);
//		int n = A.size();
//		for (int i = 0; i < n; i++) {
//			int count = 0;
//			for (int k = i + 1; k < n; k++) {
//				if (A.get(k) > A.get(i))
//					count++;
//			}
//			if (count == A.get(i))
//				return 1;
//		}
//
//		return -1;
//
//	}
	
	//Approach 2
	public int solve(ArrayList<Integer> A) {
		Collections.sort(A);
		int n = A.size();
		for (int i = 0; i < n-1; i++) {
		    if(i+1<n && A.get(i)==A.get(i+1))
		    continue;
			if(A.get(i)==n-i-1)
				return 1;
		}
		return -1;

	}


	public static void main(String[] args) {
		Test39 test26 = new Test39();
		ArrayList<Integer> test = new ArrayList<>();
		test.add(-4);
		test.add(-2);
		test.add(0);
		test.add(-1);
		test.add(-6);
		int x = test26.solve(test);
		System.out.println("=" + x);
	}
}
