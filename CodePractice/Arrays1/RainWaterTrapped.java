package arrays1;

import java.util.ArrayList;
import java.util.List;

public class RainWaterTrapped {

	public int trap(final List<Integer> A) {
		int n = A.size();
		int lmax = A.get(0);
		int rmax = A.get(n - 1);
		int lo = 0, hi = n - 1, res = 0;
		while (lo <= hi) {
			if (lmax <= rmax) {
				res += Math.max(0, lmax - A.get(lo));
				lmax = Math.max(lmax, A.get(lo));
				lo++;
			} else {
				res += Math.max(0, rmax - A.get(hi));
				rmax = Math.max(rmax, A.get(hi));
				hi--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		RainWaterTrapped rwt = new RainWaterTrapped();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(0);
		list.add(2);
		rwt.trap(list);
	}
}
