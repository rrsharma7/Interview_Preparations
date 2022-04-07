package Leetcode.Sorting;

import java.util.HashMap;
import java.util.Map;

public class LargestString {

	public String topKFrequent2(String[] A, String B[]) {
		int max = Integer.MIN_VALUE;

		String res = null;
		int index = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			max = Math.max(max, Integer.parseInt(B[i]));
		}
		for (int i = 0; i < B.length; i++) {
			if (max == Integer.parseInt(B[i])) {
				index = i;
			}
		}
		for (int i = 0; i < A.length; i++) {
			String temp = A[index];
			String con1 = temp.substring(2);
			if (con1.equalsIgnoreCase("000000")) {
				index++;
			} else {
				res = temp.substring(0, 2);
				int sum = 0;
				for (int k = 0; k < A.length; k++) {

					sum = Integer.parseInt(A[k].substring(2));
					if (map.containsKey(A[k].substring(0, 2))) {
						map.put(A[k].substring(0, 2), map.get(A[k].substring(0, 2))+sum);
						
					}else {
					map.put(A[k].substring(0, 2), sum);
					}

				}
				int max2 = Integer.MIN_VALUE;
				for (Map.Entry<String, Integer> m : map.entrySet()) {
					max2 = Math.max(max2, m.getValue());
				}
				for (Map.Entry<String, Integer> m : map.entrySet()) {
					if (max2 == m.getValue())
						res = m.getKey();

				}
				res = temp.substring(0, 2);
			}

		}
		return res;

	}

	public static void main(String[] args) {
		LargestString cd = new LargestString();
		String[] A = { "GB402342", "GB132491", "PL132028" };
		String[] B = { "2", "2", "5" };
		String ans = cd.topKFrequent2(A, B);
		System.out.println(ans);

	}

}
