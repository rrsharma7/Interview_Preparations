package problemsolving2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumDifference {
	
	
	public int solve(ArrayList<Integer> A, int B) {
		Collections.sort(A);
        long summ=0;
        for (int i=0;i<A.size();i++ ) {
            summ+=A.get(i);
        }
        long s1=0;
        for(int i=0;i<B;i++) 
        s1=s1+A.get(i);
        long s2=summ-s1;
        long ans=Math.abs(s1-s2);
        int i=A.size()-1;
        s1=0;
        while(B-->0)
        {
            s1+=A.get(i--);
        }
        s2=summ-s1;
        return (int) Math.max(ans,Math.abs(s1-s2));
	}

	public static void main(String[] s) {
		MaximumDifference md = new MaximumDifference();
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int x = md.solve(list,2);
		System.out.println(x);
	}
}
