package test;

import java.util.HashMap;
import java.util.Map;

public class Test26 {

	private int solve(int[] A, int B) {
		 int result = 0;
		    int n=A.length;
		    Map<Integer,Integer> m = new HashMap<>();
		    for (int i = 0;  i < n ; i++)
		    {
		      int curr_xor = B^A[i];
		        if (m.containsKey(curr_xor))
		            result += m.get(curr_xor);
		        if(m.containsKey(A[i]))
		        {
		            m.put(A[i], m.get(A[i]) + 1);
		        }
		        else{
		            m.put(A[i], 1);
		        }
		    }
		    return result;
	}

	public static void main(String[] args) {
		Test26 test26 = new Test26();
		int A[] = { 3, 6, 8, 10, 15, 50,3 };
		test26.solve(A, 5);
	}

}
