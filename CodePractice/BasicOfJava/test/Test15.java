// First sort array
package test;

public class Test15 {

	public int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
            count = count + 1;
            cnt_G[i] = count;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		Test15 test9 = new Test15();
		String arr = "ABCGAG";
		test9.solve(arr);
	}

}
