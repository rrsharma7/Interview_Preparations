package lovebabbar.string;

public class StringPlaindrome {

	int isPlaindrome(String str) {

		String reverse = "";
		int result = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		if (reverse.equals(str))
			result = 1;
		return result;

	}

	public static void main(String[] args) {
		StringPlaindrome stringPlaindrome = new StringPlaindrome();
		int res = stringPlaindrome.isPlaindrome("abc");
		System.out.print(res);
	}
}
