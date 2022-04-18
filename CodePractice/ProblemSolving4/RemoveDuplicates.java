package ProblemSolving4;

import java.util.ArrayList;

public class RemoveDuplicates {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		int index = 1;
		int n = A.size();
		for (int i = 1; i < n; i++) {
			if (A.get(i).intValue() != A.get(i - 1).intValue()) {
				A.set(index, A.get(i));
				index++;
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < index; i++) {
			arr.add(A.get(i));

		}
		return arr;
	}

	public static void main(String[] s) {
		RemoveDuplicates ss = new RemoveDuplicates();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		ArrayList<Integer> arrayList = ss.solve(list);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

	}
}
