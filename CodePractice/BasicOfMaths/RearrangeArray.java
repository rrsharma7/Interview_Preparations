package BasicOfMaths;

import java.util.ArrayList;

public class RearrangeArray {
public void arrange(ArrayList<Integer> A) {
	    
	    for (int i = 0; i < A.size(); i++) {
	        int index = A.get(i);
	        int val = A.get(index) % A.size() + 1;
	        A.set(i, A.get(i) + A.size() * val);
	    }
	    for (int i = 0; i < A.size(); i++) {
	        int val = A.get(i);
	        val = val / A.size() - 1;
    	    A.set(i, val);
	    }
	    for (int i = 0; i < A.size(); i++)
            System.out.print(A.get(i) + " ");
        System.out.println("");
	    
	}
	public static void main(String[] args) {
		RearrangeArray test1 = new RearrangeArray();
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(0);
		list.add(1);
		test1.arrange(list);
	

	}
	//3 2 0 1
// 1 0 3 2
}


