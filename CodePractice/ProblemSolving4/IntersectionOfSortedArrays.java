package problemsolving4;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

	public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = 0, j = 0;
		while (i < A.size() && j < B.size()) 
		{

			if (A.get(i).equals(B.get(j))) {
				ans.add(A.get(i));
				i++;
				j++;
			}

			else if (A.get(i) < B.get(j)) {
				i++;
			}

			else {
				j++;
			}
		}

		return ans;
	}

	public static void main(String[] s) {
		IntersectionOfSortedArrays ss = new IntersectionOfSortedArrays();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(5);
		ArrayList<Integer> arrayList = ss.solve(list1, list2);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

	}
}
