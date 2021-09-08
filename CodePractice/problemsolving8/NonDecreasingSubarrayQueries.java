package problemsolving8;

import java.util.ArrayList;

public class NonDecreasingSubarrayQueries {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		int n = A.size();
        int pre[] = new int[n];
        pre[0] = 0;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1];
            if(A.get(i-1) > A.get(i)) pre[i]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> i : B){
            if((int)pre[i.get(0) - 1] == pre[(i.get(1)) - 1]) {
                ans.add(1);
            } else {
                ans.add(0);
            }
        }
        return ans;
	}

	public static void main(String[] s) {
		NonDecreasingSubarrayQueries nond = new NonDecreasingSubarrayQueries();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(7);
		A.add(3);
		A.add(4);
		A.add(9);
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp1=new ArrayList<Integer>();
		temp1.add(1);
		temp1.add(2);
		ArrayList<Integer> temp2=new ArrayList<Integer>();
		temp2.add(2);
		temp2.add(4);
		B.add(temp1);
		B.add(temp2);
		nond.solve(A, B);

	}
}
