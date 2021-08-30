package lovebabbar.string;

class PrintAllSubsequences {

	public static void main(String[] args) {
		String str = "abc";
		printSS(str, "");
	}

	private static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSS(roq, ans + "");
		printSS(roq, ans + ch);

	}
}