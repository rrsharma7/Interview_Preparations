package test;

public class Test41 {

	public int[] solve(int[] A) {
		int n = A.length;
		int result[]=new int[n-1];
        for (int i = 0; i < n-1; i++)
        {
        	int min = i;
            for (int k = i+1; k < n; k++)
                if (A[k] < A[min])
                	min = k;
            
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;
            result[i]=min;
            
        }
		return result;

	}


	public static void main(String[] args) {
		Test41 test26 = new Test41();
		int a[]= {6, 4, 3, 7, 2, 8};
		test26.solve(a);
	}
}
