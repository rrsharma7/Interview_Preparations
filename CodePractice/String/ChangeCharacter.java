package string;

import java.util.Arrays;

public class ChangeCharacter {

	public int solve(String A, int B) {
		int n = A.length();
		int arr[] = new int[26];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			arr[A.charAt(i) - 'a']++;
			if (arr[A.charAt(i) - 'a'] == 1) {
				ans++;
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < 26; i++) {
			if (B - arr[i] >= 0 && arr[i] != 0) {
				ans--;
				B =B-arr[i];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		ChangeCharacter test1 = new ChangeCharacter();
		String A = "abcabbccd";
		int B = 3;
		int str = test1.solve(A, B);
		System.out.println(str);

	}

}
