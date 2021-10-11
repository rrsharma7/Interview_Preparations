/**
Minimum Swaps To Arrange Pairs
Problem Description

There are A pairs and therefore 2A people. Each person has a unique number ranging from 1 to 2A. An array of integers B shows the arrangement of these 2A people.

A matrix C of size A x 2 is given describing pairs i.e. people that are partner of each other. C[i][0] and C[i][1] are partner of each other.

Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.



Problem Constraints
1 <= A <= 20

1 <= B[i] <= 2*A

C[i][0]!=C[i][1]

1 <= C[i][0], C[i][1] <= 2*A



Input Format
The First argument given is an integer A.

The Second argument given is the integer array B.

The Third argument given is matrix C.



Output Format
Return the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.



Example Input
Input 1:

A = 3
B = [3, 5, 6, 4, 1, 2]
C = [   [1, 3]
        [2, 6]
        [4, 5]  ]
Input 2:

A = 1
B = [1, 2]
C = [ [1, 2] ]


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

One of the ways to arraange them 
1. swap(5 and 6) order becomes : [3, 6, 5, 4, 1, 2]
2. swap(6 and 1) order becomes:  [3, 1, 5, 4, 6, 2]
Explanation 2:

No swaps required. */
package RecursionBacktracking1;

import java.util.ArrayList;
import java.util.Arrays;

class MinimumSwapsToArrangePairs {

	public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
		int pos[] = new int[2 * A + 1];
		int pair[] = new int[2 * A + 1];
		// assign initial positions
		for (int i = 0; i < B.size(); i++) {
			pos[B.get(i)] = i;
		}
		// intialize pair array
		for (int i = 0; i < C.size(); i++) {
			int x = C.get(i).get(0), y = C.get(i).get(1);
			pair[x] = y;
			pair[y] = x;
		}
		int ans = 0;
		for (int i = 0; i < B.size(); i++) {
			int p1 = B.get(i);
			int p2 = pair[p1], poss = pos[p2];
			int cur = B.get(i + 1);
			if (cur != p2) {
				B.set(poss, cur);
				ans++;
				pos[cur] = poss;
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		MinimumSwapsToArrangePairs mstap = new MinimumSwapsToArrangePairs();
		ArrayList<Integer> bArr = new ArrayList<Integer>();
		bArr.add(3);
		bArr.add(5);
		bArr.add(6);
		bArr.add(4);
		bArr.add(1);
		bArr.add(2);
		ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
		group.add(new ArrayList<Integer>((Arrays.asList(1, 3))));
		group.add(new ArrayList<Integer>((Arrays.asList(2, 6))));
		group.add(new ArrayList<Integer>((Arrays.asList(4, 5))));
		int res = mstap.solve(3, bArr, group);
		System.out.println("res=" + res);
	}

}
