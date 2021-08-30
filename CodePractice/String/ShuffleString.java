package lovebabbar.string;

public class ShuffleString {

	static boolean shuffleString(String str1, String str2, String result) {

		int l1 = str1.length();
		int l2 = str2.length();
		int lr = result.length();

		if (l1 + l2 != lr) {
			return false;
		} else {
			int i = 0, j = 0, k = 0;
			while (k < lr) {

				if (i < l1 && str1.charAt(i) == result.charAt(k))
					i++;
				else if (j < l2 && str2.charAt(j) == result.charAt(k))
					j++;
				else
					return false;

				k++;
			}
			if (i < l1 || j < l2)
				return false;
			else
				return true;

		}

	}

	public static void main(String[] args) {

		String str1 = "XY";
		String str2 = "12";
		String result = "YX12";
		boolean shuffleCheck = shuffleString(str1, str2, result);
		System.out.println("shuffleCheck=" + shuffleCheck);
	}

}
