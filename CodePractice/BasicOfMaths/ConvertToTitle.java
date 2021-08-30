package BasicOfMaths;

public class ConvertToTitle {
	
	public  String convertToTitle(int A) {
		StringBuffer title = new StringBuffer();
		while (A > 0) {
			A--;
			char ch = (char) (A % 26 + 'A');
			title.append(ch);
			A = A/26;
		}
		
		title.reverse();
		return title.toString();
	}

	public static void main(String[] args) {
		ConvertToTitle test1 = new ConvertToTitle();
		String ans = test1.convertToTitle(28);
		System.out.println("ans=" + ans);

	}

}
