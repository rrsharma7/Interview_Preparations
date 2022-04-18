package ProblemSolving4;

import java.util.HashMap;

public class MajorityElement {

	public int majorityElement(final int[] A) {
		HashMap<Integer, Integer> hsMap = new HashMap<Integer, Integer>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int elementAppear=n/2;
			if (hsMap.containsKey(A[i])) 
			{
				hsMap.put(A[i], hsMap.get(A[i]) + 1);
				if(hsMap.get(A[i]) > elementAppear)
				{
					return A[i];
				}
			} else
				hsMap.put(A[i], 1);
		}

		return A[0];

	}

	public static void main(String[] s) {
		MajorityElement majorityElement = new MajorityElement();
		int nums[] = {668474};
		int result = majorityElement.majorityElement(nums);
		System.out.print("result=" + result);

	}
}
