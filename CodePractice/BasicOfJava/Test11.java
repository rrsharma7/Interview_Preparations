// First sort array
package test;

public class Test11 {

	public int solve(int[] A) {
		int count = 1;
		boolean flag =false;
		if(A[0]%2!=0)
		{
			flag=true; 
		}
		for (int i = 1; i < A.length; i++) {
			
			if(A[i]%2==0 && flag)
			{
				++count;
				flag=false;
			}
			else if(A[i]%2!=0 && !flag)
			{
				++count;
				flag=true;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Test11 test9 = new Test11();
		int arr[] = {1, 2, 2, 5, 6};
		int a = test9.solve(arr);
		System.out.println("count=" + a);

	}

}
