package test;

import java.util.Arrays;

public class Test40 {

	public int[] wave(int[] A) {
		int n = A.length;
		int[] result = new int[A.length];
		Arrays.sort(A);
		for (int i = 0; i <n-1; i+=2)
		{ 
			int temp=A[i];
			A[i]=A[i+1];
			A[i+1]=temp;
		}
		for(int i=0;i<A.length;i++)
		result[i]=A[i];	
		return result;
	}

	public static void main(String[] args) {
		Test40 test26 = new Test40();
		int a[] = { 1, 2, 3, 4 };
		test26.wave(a);

	}
}
