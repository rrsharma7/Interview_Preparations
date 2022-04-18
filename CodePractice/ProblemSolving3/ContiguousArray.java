package ProblemSolving3;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public int solve(int[] A) {
		   Map<Integer, Integer> map = new HashMap<>();
	    	int maxlen = 0, count = 0;
	    	for(int i = 0;i < A.length;i++) {
	    		 count = count + (A[i] == 1 ? 1 : -1);
	    		if(count == 0)
	    			maxlen = Math.max(maxlen, i+1);    		
	    		if(map.containsKey(count)) {
	    			maxlen = Math.max(maxlen, i - map.get(count));
	    		} else 
	    			map.put(count, i);
	    	}
	    	return maxlen;
	}

	public static void main(String[] s) {
		ContiguousArray contiguousArray = new ContiguousArray();
		int nums[] = { 1, 0, 1, 0, 1 };
		int result = contiguousArray.solve(nums);
		System.out.print("result=" + result);

	}
}
