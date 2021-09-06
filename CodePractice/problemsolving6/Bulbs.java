package problemsolving6;

import java.util.ArrayList;

public class Bulbs {

	public int bulbs(ArrayList<Integer> A) {
		int state = 0;
		int ans = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == state) {
				ans++;
				state = 1 - state;
			}
		}
		return ans;
	}

	public static void main(String[] s) {
		Bulbs ss = new Bulbs();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(1);
		int ans = ss.bulbs(list);
		System.out.println(ans);

	}
}
