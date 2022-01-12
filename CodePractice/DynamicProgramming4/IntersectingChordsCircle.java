/**
Q3. Intersecting Chords in a Circle

Problem Description

Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 109 + 7.



Problem Constraints

1 <= A <= 103



Input Format

The first and the only argument contains the integer A.



Output Format

Return an integer answering the query as described in the problem statement.



Example Input

Input 1:

 A = 1
Input 2:

 A = 2


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are: {(1-2)} only. So, we return 1.
Explanation 2:

 If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
 So, we return 2.
*/

package DynamicProgramming4;

class IntersectingChordsCircle {

	public int chordCnt(int count) {
        long[] ways = new long[count+1];
        ways[0] = 1L;
        long mod = 1000000007;
        for (int index = 1; index <= count; index++) {
            for (int left = 0; left < index; left++) {
                int right = index - left - 1;
                ways[index] += ways[left] * ways[right];
                ways[index] %= mod;
            }
        }
        return (int)ways[count];
    }

	public static void main(String[] args) {
		IntersectingChordsCircle icc = new IntersectingChordsCircle();
		int ans = icc.chordCnt(2);
		System.out.println(ans);
	}

}