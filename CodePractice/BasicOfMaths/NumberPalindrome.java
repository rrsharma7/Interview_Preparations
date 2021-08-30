package BasicOfMaths;

public class NumberPalindrome {
	public int isPalindrome(int A) {
	
		int num=A;
		int temp = 0;
		if (A <0)
			return 0;	
	    while (A!= 0)
	    {
	        temp = temp * 10 + A % 10;
	        A /= 10;
	        
	    }
	    if(temp==num)
	    	 return 1;
	    return 0;
	}

	public static void main(String[] args) {
		NumberPalindrome test1 = new NumberPalindrome();
		int ans = test1.isPalindrome(12121);
		System.out.println("ans=" + ans);

	}

}
