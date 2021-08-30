// First sort array
package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test12 {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		Collections.sort(A);
		A.set(A.size() - 1, A.get(A.size() - 1) + 1);
		return A;
	}

	public static void main(String[] args) {
		Test12 test9 = new Test12();
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		test9.solve(list);

	}

}
