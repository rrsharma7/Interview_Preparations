package lovebabbar.string;

//Java program to find n'th
//term in look and say sequence

class CountAndSay {

	static String countnndSay(int n) {

		System.out.println("n==="+n);
		if (n <= 0)
			return null;
	 
		String result = "1";
		int i = 1;
		
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
	 
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}
	 
		return result;
	}

	public static void main(String[] args) {
		int N = 3;
		System.out.println(countnndSay(N));
	}
}

//1
//11
//21   --> 2 - how much time 1---> which number
//1211   