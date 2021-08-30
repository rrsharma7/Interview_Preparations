package test;

public class Test5 {

	public int singleNumber(final int[] A) {
		int count = 0;
		for(int i=0;i<A.length;i++)
		{
			count=count^A[i];
		}
		return count;
	}

	public static void main(String[] args) {
		Test5 test5 = new Test5();
		int[] arr = {1, 2, 2, 3, 1};
		int count=test5.singleNumber(arr);
		System.out.println("count=" + count);
	}

}
