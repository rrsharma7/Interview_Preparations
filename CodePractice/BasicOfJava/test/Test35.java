package test;

public class Test35 {

	public int solve(String[] A, String B) {
		int len = A.length;
		for (int i = 0; i < len - 1; i++) {
			String curr = A[i];
			String next = A[i + 1];

			int len1 = curr.length();
			int len2 = next.length();
			if (len1 > len2 && curr.startsWith(next))
				return 0;

			int min = Math.min(len1, len2);
			for (int j = 0; j < min; j++) {
				if (B.indexOf(curr.charAt(j)) < B.indexOf(next.charAt(j)))
					break;
				else if (B.indexOf(curr.charAt(j)) > B.indexOf(next.charAt(j)))
					return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Test35 test26 = new Test35();
		String A[] = { "hello", "scaler", "interviewbit" };
		String B = "adhbcfegskjlponmirqtxwuvzy";
		int x=test26.solve(A, B);
		System.out.println("x==="+x);
	}
}
