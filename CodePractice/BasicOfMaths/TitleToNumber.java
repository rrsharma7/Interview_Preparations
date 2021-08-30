package BasicOfMaths;

public class TitleToNumber {
	public int titleToNumber(String A) {
		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			
			result *= 26;
			result += A.charAt(i) - 'A' + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		TitleToNumber test1 = new TitleToNumber();
		int ans = test1.titleToNumber("AB");
		System.out.println("ans=" + ans);

	}

}
