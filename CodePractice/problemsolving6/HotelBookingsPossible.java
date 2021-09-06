package problemsolving6;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible

{
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int i = 0;
		int j = 0;

		while (i < arrive.size() && j < depart.size()) {
			if (arrive.get(i) < depart.get(j)) {
				i++;
				K--;
			} else if (arrive.get(i) == depart.get(j)) {
				i++;
				j++;
			} else {
				j++;
				K++;
			}

			if (K < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] s) {
		HotelBookingsPossible hbp = new HotelBookingsPossible();
		ArrayList<Integer> arriveList = new ArrayList<>();
		arriveList.add(1);
		arriveList.add(2);
		arriveList.add(3);
		ArrayList<Integer> departList = new ArrayList<>();
		departList.add(2);
		departList.add(3);
		departList.add(4);
		boolean ans = hbp.hotel(arriveList, departList, 1);
		System.out.println(ans);

	}
}
