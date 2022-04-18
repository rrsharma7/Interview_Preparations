package Arrays1;

import java.util.ArrayList;

public class AddOneToNumber {
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int i = 0;
		while (i < A.size() - 1 && A.get(i) == 0) {
			A.remove(i);
		}
		int carry = 1;
		int sum;
		for (i = A.size() - 1; i >= 0; i--) {
			sum = A.get(i) + carry;
			A.set(i, sum % 10);
			carry = sum / 10;
			if (carry == 0) {
				break;
			}
		}
		if (carry != 0) {
			A.add(0, carry);
		}
		return A;
	}

	public static void main(String[] args) {
		AddOneToNumber addOne = new AddOneToNumber();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		addOne.plusOne(list);

	}
}
