/**
 * Min XOR value
Problem Description

Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting minimum xor value.



Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 0 xor 2 = 2
 */
package BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {

	public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<A.size()-1; i++) {
            int xor = A.get(i) ^ A.get(i+1);
            min = Math.min(min, xor);
        }
        
        return min;
    }
	public static void main(String[] s) {
		MinXORValue mov = new MinXORValue();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(0);
		arrList.add(2);
		arrList.add(5);
		arrList.add(7);
		int res = mov.findMinXor(arrList);
		System.out.println(res);

	}
}
