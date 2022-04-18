package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Test34 {

	public int colorful(int A) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<>();
		while (A > 0) {
			int temp = A % 10;
			list.add(temp);
			A = A / 10;
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) 
		{
			int product = 1;
			for (int k= i; k < list.size(); k++) 
			{
				product = product * list.get(k);
				if (hs.contains(product))
					return 0;
				else
					hs.add(product);
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		Test34 test26 = new Test34();
		int x = test26.colorful(23);
		System.out.println("x===" + x);
	}
}
