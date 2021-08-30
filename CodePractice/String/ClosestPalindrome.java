package string;

public class ClosestPalindrome {

	public String solve(String A) {
		String ans = "";
		 int j = A.length(), i = 0;
	        j = j - 1;
	        int count = 0;
		if (checkPalindrome(A)) {
			if (A.length() % 2 == 1)
				ans = "YES";
			else
				ans = "NO";
			}
		else
			while (i <= j) {
                if (A.charAt(i) != A.charAt(j))
                    count++;
                i++;
                j--;
            }
            if (count > 1)
                ans = "NO";
            else
                ans = "YES";
		return ans;
	}

	private static boolean checkPalindrome(String s) {
		  int l = s.length();
	        for (int i = 0; i < l; i++) {
	            if (s.charAt(i) != s.charAt(l - 1 - i))
	                return false;
	        }
	        return true;
	}

	public static void main(String[] args) {
		ClosestPalindrome test1 = new ClosestPalindrome();
		String str = test1.solve("aaaaaaaaaabaaaaaaaaa");
		System.out.println("=" + str);

	}

}
