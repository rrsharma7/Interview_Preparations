package test;

public class Test30 {

	 public int[] solve(int[] A, int B) {
	      long n = A.length;
	      int l = 0, r = 0;
	      long sum = A[l];
	      while (r < n && l <= r) 
	      {
	         if (sum == B) {
	            int[] ans = new int[r - l + 1];
	            for (int i = l; i <= r; i++) ans[i - l] = A[i];
	            return ans;
	         } else if (sum < B) {
	            r++;
	            if (r < n) sum += A[r];
	         } else {
	            sum -= A[l];
	            l++;
	         }
	      }
	      int ans[] = new int[1];
	      ans[0] = -1;
	      return ans;
	   }

	public static void main(String[] args) {
		Test30 test26 = new Test30();
		int A[]= {1, 2, 3, 4, 5};
		test26.solve(A, 5);
	}

}
