// First sort Aay
package test;

public class Test23 {

	 public int solve(int[][] a, int b) {
	        int n = a.length, m = a[0].length;
	        for (int i = 1; i <=n; i++)
	            for (int j = 1; j <=m; j++)
	                if (a[i-1][j-1] == b)
	                	
	                	 return (i * 1009 + j);
	        
	        return -1;
	    }

	public static void main(String[] args) {
		Test23 test9 = new Test23();
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		test9.solve(arr, 2);
	}
}
