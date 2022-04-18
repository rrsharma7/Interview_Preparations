package Arrays1;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		long maxSum = 0;
		long newSum = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		for (Integer i : A) {
			if (i >= 0) {
				newSum += i;
				tempArray.add(i);
			} else {
				newSum = 0;
				tempArray = new ArrayList<Integer>();
			}
			if ((maxSum < newSum) || ((maxSum == newSum) && (tempArray.size() > maxArray.size()))) {
				maxSum = newSum;
				maxArray = tempArray;
			}
		}
		return maxArray;
	}

	public static void main(String[] args) {
		MaxNonNegativeSubArray mnsa = new MaxNonNegativeSubArray();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(-7);
		list.add(2);
		list.add(3);
		mnsa.maxset(list);

	}
}
