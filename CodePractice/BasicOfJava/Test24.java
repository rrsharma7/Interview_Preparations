package test;

import java.util.HashMap;

public class Test24 {
	public int[] solve(int[] A, int B) {
		int n = A.length;
		int result[] = new int[2];
		HashMap<Integer, Integer> hsMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hsMap.containsKey(B - A[i])) {
				int index2=i+1;
				int index1=hsMap.get(B-A[i])+1;
				result[0]=index1;
				result[1]=index2;
				return result;
			} else {
				if (!hsMap.containsKey(A[i])) {
					hsMap.put(A[i], i);
				}
			}

		}
		result=new int[0];
		return result;

	}

	public static void main(String[] args) {
		Test24 test9 = new Test24();
//		int[] arr = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4,
//				4, -8 };
		int[] arr = { 2, 7, 11, 15 };
		test9.solve(arr, 9);
	}
}

//4,8