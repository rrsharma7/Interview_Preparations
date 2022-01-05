/**
Q1. Ways to Decode

Problem Description

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.

.



Problem Constraints

1 <= length(A) <= 105



Input Format

The first and the only argument is a string A.



Output Format

Return an integer, representing the number of ways to decode the string modulo 109 + 7..



Example Input

Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
*/

package DynamicProgramming1;

class WaysToDecode {

	
	public int numDecodings(String str) {
        int n=str.length();
        if(str==null||n==0)
            return 0;
        int dp[]=new int[n+1];
        dp[0]=1;
        if(str.charAt(0)!='0')
            dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int first=Integer.parseInt(str.substring(i-1,i));
            int second=Integer.parseInt(str.substring(i-2,i));
            if(first>=1&&first<=9)
                dp[i]=dp[i]+dp[i-1];
            if(second>=10&&second<=26)
                dp[i]=dp[i]+dp[i-2];
        }
        return dp[n];
    }


	
	public static void main(String[] args) {
		WaysToDecode wtd = new WaysToDecode();
		int ans = wtd.numDecodings("1");
		System.out.println(ans);
	}

}