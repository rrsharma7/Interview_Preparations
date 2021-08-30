package recursion;

public class StringRecursionPalindrome {

	public int solve(String A) {
        if(A.length() == 0 || A.length() == 1)
            return 1; 
        if(A.charAt(0) == A.charAt(A.length()-1))
        return solve(A.substring(1, A.length()-1));
        return 0;
	}
	public static void main(String[] args) {
		StringRecursionPalindrome test1 = new StringRecursionPalindrome();
		String A = "strings";
		int str = test1.solve(A);
		System.out.println(str);

	}

}
