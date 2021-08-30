// First sort array
package test;

public class Test16 {

	public int[][] solve(int A) {
        int[][] ans = new int[A][A];
        for(int i=0;i<A;i++)
        {
            for(int j=0;j<A-i-1;j++)
                ans[i][j]=0;
            int col = A-i-1;
            for(int j = i+1;j>=1;j--)
                ans[i][col++]=j;
        }
        return ans;
    }

	public static void main(String[] args) {
		Test16 test9 = new Test16();
		test9.solve(4);
	}

}
