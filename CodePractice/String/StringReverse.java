package lovebabbar.string;

public class StringReverse {

	public String reverseString(String str) {
		String reverse = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}

		return reverse;
	}

	public static void main(String[] args) {
		StringReverse sr = new StringReverse();
		String result = sr.reverseString("rahul sharma");
		System.out.print(result);

	}

}
