// First sort array
package test;

public class Test14 {
	
	 public int solve(int[] A) {
	        int N = A.length;

	        int countP = 0;
	        for (int i = 0; i < N;i++){
	            if(A[i] > 1){
	                boolean check = true;
	                for (int j = 2; j*j<= A[i];j++){
	                    if(A[i] % j == 0){
	                        check = false;
	                    }
	                }
	                if(check){
	                    countP++;
	                }
	            }
	        }
	        
	        return countP;
	    }

//	public int solve(int[] A) {
//		int count = 0;
//		for (int i = 0; i < A.length; i++) {
//			if(A[i]>1 && A[i]%2==0)
//				count++;
//		}
//		int result=A.length-count;
//		return result;
//	}

	public static void main(String[] args) {
		Test14 test9 = new Test14();
		int arr[] = { -11, 7, 8, 9, 10, 11};
		test9.solve(arr);
	}

}
