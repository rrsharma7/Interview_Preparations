// First sort Aay
package test;

public class Test19 {

	public int solve(String A) {
		int[] leftArray = new int[A.length()];
		int[] rightArray = new int[A.length()];
		int c = 0;
		int ans = 0;
		int maxCount = 0;
	
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '1') {
				maxCount++;
			}
		}
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '1') {
				c++;
				leftArray[i] = c;
			} else {
				c = 0;
				leftArray[i] = c;
			}
			ans=Math.max(ans, leftArray[i]);
		}
		c=0;
		for (int j = A.length() - 1; j >= 0; j--) {
			if (A.charAt(j) == '1') {
				c++;
				rightArray[j] = c;
			} else {
				c = 0;
				rightArray[j] = c;
			}
			ans=Math.max(ans, rightArray[j]);
		}
		
		for (int i = 1; i <A.length() - 1; i++) {
			if (A.charAt(i) == '0') {
				int sum = leftArray[i - 1] + rightArray[i + 1];
				if (sum == maxCount) {
					sum--;
				}
				ans = Math.max(ans, sum + 1);

			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Test19 test9 = new Test19();
		test9.solve("01");
	}

}
