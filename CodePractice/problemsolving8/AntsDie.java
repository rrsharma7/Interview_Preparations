package problemsolving8;

import java.util.ArrayList;

public class AntsDie {

	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		
		int result = 0;
        for(int i:B)
            result = Math.max(result,i);
        if(result>=A)
            return result;
        for(int i:C)
            result = Math.max(result,A-i);
        return result;
	}

	public static void main(String[] s) {
		AntsDie antsDie = new AntsDie();
		ArrayList<Integer> left = new ArrayList<>();
		left.add(4);
		left.add(3);
		ArrayList<Integer> right = new ArrayList<>();
		right.add(0);
		right.add(1);
		int res=antsDie.solve(4, left, right);
		System.out.println(res);

	}
}
