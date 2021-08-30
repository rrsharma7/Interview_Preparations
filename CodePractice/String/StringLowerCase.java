package string;

public class StringLowerCase {

	public char[] to_lower(char[] A) {
		char chArray[] = new char[A.length];
		for (int i = 0; i < A.length; i++) {
			char ch = Character.toLowerCase(A[i]);
			chArray[i] = ch;

		}

		return chArray;

	}


	public static void main(String[] args) {
		StringLowerCase test1 = new StringLowerCase();
		char ch[] = { 'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y' };
		test1.to_lower(ch);

	}

}
