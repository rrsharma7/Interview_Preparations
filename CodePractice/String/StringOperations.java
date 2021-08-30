package string;

public class StringOperations {

	public String solve(String A) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
				if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o'
						|| A.charAt(i) == 'u') {
					sb.append("#");
				} else {
					sb.append(A.charAt(i));
				}
			}
		}
		sb.append(sb);
		return sb.toString();
	}

	public static void main(String[] args) {
		StringOperations test1 = new StringOperations();
		test1.solve("AbcaZeoB");

	}

}
