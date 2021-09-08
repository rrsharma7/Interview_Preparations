package problemsolving8;

import java.util.ArrayList;

public class CircleOfMonsters {

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		long ans = 0;
		long mn = 10000000000000000L;
		int n = A.size();
		for (int i = 0; i < n; i++) {
			int ni = (i + 1) % n;
			long val = Math.min(A.get(ni), B.get(i));
			ans = ans+A.get(ni) - val;
			mn = Math.min(mn, val);
		}
		ans = ans+mn;
		return (int) (ans % 1000000007);
	}

	public static void main(String[] s) {
		CircleOfMonsters circleOfMonsters = new CircleOfMonsters();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(7);
		list1.add(2);
		list1.add(5);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(15);
		list2.add(14);
		list2.add(3);
		circleOfMonsters.solve(list1, list2);

	}
}
