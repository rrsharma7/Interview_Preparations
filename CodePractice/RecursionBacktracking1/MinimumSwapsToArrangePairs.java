package RecursionBacktracking1;

import java.util.ArrayList;
import java.util.Arrays;

class MinimumSwapsToArrangePairs {

	public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
		int pos[] = new int[2 * A + 1];
		int pair[] = new int[2 * A + 1];
		// assign initial positions
		for (int i = 0; i < B.size(); i++) {
			pos[B.get(i)] = i;
		}
		// intialize pair array
		for (int i = 0; i < C.size(); i++) {
			int x = C.get(i).get(0), y = C.get(i).get(1);
			pair[x] = y;
			pair[y] = x;
		}
		int ans = 0;
		for (int i = 0; i < B.size(); i++) {
			int p1 = B.get(i);
			int p2 = pair[p1], poss = pos[p2];
			int cur = B.get(i + 1);
			if (cur != p2) {
				B.set(poss, cur);
				ans++;
				pos[cur] = poss;
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		MinimumSwapsToArrangePairs mstap = new MinimumSwapsToArrangePairs();
		ArrayList<Integer> bArr = new ArrayList<Integer>();
		bArr.add(3);
		bArr.add(5);
		bArr.add(6);
		bArr.add(4);
		bArr.add(1);
		bArr.add(2);
		ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
		group.add(new ArrayList<Integer>((Arrays.asList(1, 3))));
		group.add(new ArrayList<Integer>((Arrays.asList(2, 6))));
		group.add(new ArrayList<Integer>((Arrays.asList(4, 5))));
		int res = mstap.solve(3, bArr, group);
		System.out.println("res=" + res);
	}

}
