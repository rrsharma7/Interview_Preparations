package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test25 {

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> resultList = new ArrayList<>();
		HashMap<Integer, Integer> hsMap = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			hsMap.put(A.get(i),hsMap.getOrDefault(A.get(i),0)+1);
		}
		for (Integer element : B) {
		    if(hsMap.getOrDefault(element,0)!=0)
		    {
	            resultList.add(element);
	            hsMap.put(element,hsMap.getOrDefault(element,0)-1);
		    }

		}
		return resultList;
	}
	public static void main(String[] args) {
		Test25 test9 = new Test25();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(1);
		list1.add(4);
		list1.add(10);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(6);
		list2.add(2);
		list2.add(10);
		list2.add(10);
		test9.solve(list1, list2);
	}

}

