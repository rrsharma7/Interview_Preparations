package problemsolving8;

import java.util.ArrayList;
import java.util.Collections;

public class GravityFlip { 

	public ArrayList<Integer> solve(ArrayList<Integer> A) {
		Collections.sort(A);
		return A;
    }
	public static void main(String[] s) {
		GravityFlip gravityFlip = new GravityFlip();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(2);
		gravityFlip.solve(list);
	

	}
}
