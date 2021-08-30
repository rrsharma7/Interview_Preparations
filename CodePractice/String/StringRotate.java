package string;

public class StringRotate {

	public String solve(String A, int B) {
		 char[] ch = A.toCharArray();
		 int len = ch.length;
	     B = B%len;
	     reverse(ch, 0, len - B - 1);
	     reverse(ch, len - B, len - 1);
	     reverse(ch, 0, len - 1);
	     return String.valueOf(ch);
	}

	private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
	public static void main(String[] args) {
		StringRotate test1 = new StringRotate();
		String A = "scaler";
		int B = 2;
		String str = test1.solve(A, B);
		System.out.println(str);

	}

}
