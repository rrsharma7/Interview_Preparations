package MathsModularArithmetic;

import java.util.HashMap;

public class ModSum {

	public int solve(int[] A) {
	    
	    int mod = 1000*1000*1000+7;
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    for(int i = 0 ; i < A.length ; i++)
	        map.put(A[i],map.getOrDefault(A[i],0)+1); 
	      long sum = 0;
	    for(int i = 1 ; i <= 1000; i++){
	        for(int j = 1; j <= 1000 ; j++){
	            int freA_i = map.getOrDefault(i,0);
	            int freA_j = map.getOrDefault(j,0);
	            sum +=  (freA_i * freA_j)*(i%j);
	            sum = (sum%mod+mod)%mod;
	        }
	    }
	    return (int)(sum%mod);
	}

	public static void main(String[] args) {
		ModSum modSum = new ModSum();
		int A[]= {1, 2, 3};
		int x=modSum.solve(A);
		System.out.println(x);

	}
}

