package LeetCode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*package whatever //do not write package name here */
import java.io.*;

class GFG {
	public static int findPeriod(String A)
	{
		int length = A.length();

		// Initially consider there is no period for given
		// String
		int period = -1;

		/*set two pointers one(i) at
		index 0 and other(j) at index 1. increment j till
		first character is obtained in the string*/
		int i = 0;
		for (int j = 1; j < length; j++) {
			int currChar = A.charAt(j);
			int comparator = A.charAt(i);

			/*If current character matches with first
			*character
			*update period as the difference of j and i*/
			if (currChar == comparator) {
				period = (j - i);
				i++;
			}

			/* if any mismatch occurs in between set i to
			* zero also check if current character again
			* matches
			* with starting character. If matches, update
			* period*/
			else {
				if (currChar == A.charAt(0)) {
					i = 1;
					period = j;
				}
				else {
					i = 0;
					period = -1;
				}
			}
		}

		/*check if the period is exactly dividing
		* string if not reset the period to -1
		* this eliminates partial substrings like
		* e.g string -"GEEKSFORGEEKS" */

		period = (length % period != 0) ? -1 : period;
		return period;
	}
	public static void main(String[] args)
	{
		String[] testStrings
			= { "XXABCDEFXXABCDEF"};
		int n = testStrings.length;
		for (int i = 0; i < n; i++) {
			if (findPeriod(testStrings[i]) == -1)
				System.out.println("false");
			else
				System.out.println("True");
		}
	}
}
