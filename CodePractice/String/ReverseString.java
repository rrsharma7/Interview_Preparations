package string;

public class ReverseString {

	public String solve(String A) {
		 StringBuilder sb = new StringBuilder();
		String noSpace= A.replaceAll("\\s+", " ").trim();
		String[] ans = noSpace.split(" ");
		for(int i = ans.length-1;i>=0;i--)
			sb.append(ans[i]).append(" ");
		
		return sb.toString().trim();

	}

	public static void main(String[] args) {
		ReverseString test1 = new ReverseString();
		String ans = test1.solve("the sky is                              blue");
		System.out.println("ans=" + ans);

	}

}
//"blue is sky the"