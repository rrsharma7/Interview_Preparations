package Leetcode.Sorting;

public class CustomeSortString {

	public String customSortString(String order, String str) {
		int[] freq = new int[26];
		for (char c : str.toCharArray()) {
			freq[c - 'a']++;
		}
		StringBuilder ans = new StringBuilder();
		for (char orderChar : order.toCharArray()) {
			while (freq[orderChar - 'a'] > 0) {
				ans.append(orderChar);
				freq[orderChar - 'a']--;
			}
		}

		for (int i = 0; i < 26; i++) {
			int freqC = freq[i];
			while (freqC > 0) {
				ans.append((char) (i + 'a'));
				freqC--;
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		CustomeSortString cs = new CustomeSortString();
		String ans = cs.customSortString("cba", "abcd"); // cbad
		//String ans = cs.customSortString("kqep", "pekeq");
		System.out.println(ans);

	}

}
