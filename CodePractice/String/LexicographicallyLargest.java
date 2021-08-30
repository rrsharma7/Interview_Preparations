package string;

public class LexicographicallyLargest {

	public String getLargest(String A) {
		return A;
    }

	public static void main(String[] args) {
		LexicographicallyLargest test1 = new LexicographicallyLargest();
		String A = "abb_c";
		String str = test1.getLargest(A);
		System.out.println(str);

	}

}
