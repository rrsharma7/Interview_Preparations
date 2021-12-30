/**
Q2. Count the primes

Problem Description

Given an array A, containing positive integers. You need to perform some queries on it.

You will be given Q Queries. Each query will have one string and two integers. Each Query can be of two type :

"C" X Y - Here "C" says that we need to Change the integer at position X to integer Y.
"A" X Y - Here "A" say that we are Asked number of primes in the the range : [X, Y] (inclusive)
For each Query of type 2, you need to calculate an integer denoting the answer to it.

NOTE:

Assume 1-indexing for all queries.
Your code will be run on multiple test cases (< 10). Make sure to come up with an optimised solution and take care of clearing global variables.


Problem Constraints

1 <= Size of A <= 4 * 104

1 <= A[i] <= 106

1 <= Number of Queries (Size of B, C, D) <= 5 * 104



Input Format

First argument is an integer array A.
Second argument is a string array B.
Third argument is an integer array C.
Fourth argument is an integer array D.

In the i-th query, B[i] dentotes the string, C[i] denotes X and D[i] denotes Y.



Output Format

Return an integer array, where each of the element represents the answer to the queries of type 2, in chronological order.



Example Input

Input 1:

 A = [1, 3, 121, 20, 17, 26, 29]
 B = ["A", "C", "A"]
 C = [1, 3,  1]
 D = [7, 19, 7]
Input 2:

 A = [7, 15, 11]
 B = ["C", "A"]
 C = [2, 2]
 D = [9, 3]


Example Output

Output 1:

 [3, 4]
Input 2:

 [1]


Example Explanation

Explanation 1:

 Given array A = [1, 3, 121, 20, 17, 26, 29]. Let's list down queries:
 1. A 1 7 :  Number of primes in complete array [1-7] is 3 => 3, 17, 29
 2. C 3 19 : Change the number at index-3 to 19. So Array becomes : [1, 3, 19, 20, 17, 26, 29]
 3. A 1 7 : Number of primes in complete array [1-7] is 4 => 3, 19, 17, 29
 So output : [3, 4]
Explanation 2:

 Given array A = [7, 15, 11]. Let's list down queries:
 1. C 2 9 :  Change the number at index-2 to 9. So Array becomes : [7, 9, 11]
 2. A 2 3 : Number of primes in array [2 - 3] is 1 => 11
 So output : [1]


*/

package SegmentTrees;

import java.util.*;

class CountPrime {
	static int N = 40010;
    static int M = 1000010;
    static int[] segtree = new int[4 * N];
    static int[] a = new int[N];
    static int n, q;
    static boolean[] isPrime = new boolean[M];
    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < M; i++) {
            if (isPrime[i] == true) {
                int j = i * 2;
                while (j < M) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }
    }
    public static void init(int l, int r, int pos) {
        if (l == r) {
            segtree[pos] = a[l];
            return;
        }
        int md = (l + r) >> 1;
        init(l, md, pos * 2 + 1);
        init(md + 1, r, pos * 2 + 2);
        segtree[pos] = segtree[pos * 2 + 1] + segtree[pos * 2 + 2];
    }
    public static void update(int l, int r, int ql, int qr, int pos, int v) {
        if (ql > r || qr < l)
            return;
        if (l == r) {
            a[l] = v;
            segtree[pos] = a[l];
            return;
        }
        int md = (l + r) >> 1;
        update(l, md, ql, qr, pos * 2 + 1, v);
        update(md + 1, r, ql, qr, pos * 2 + 2, v);
        segtree[pos] = segtree[pos * 2 + 1] + segtree[pos * 2 + 2];
    }
    public static int geta(int l, int r, int ql, int qr, int pos) {
        if (ql > r || qr < l)
            return 0;
        if (ql <= l && qr >= r)
            return segtree[pos];
        int md = (l + r) >> 1;
        return geta(l, md, ql, qr, pos * 2 + 1) + geta(md + 1, r, ql, qr, pos * 2 + 2);
    }
    public int[] solve(int[] A, String[] B, int[] C, int[] D) {
        n = A.length;
        sieve();
        for (int i = 0; i < n; i++) {
            if (isPrime[A[i]])
                a[i] = 1;
            else
                a[i] = 0;
        }
        init(0, n - 1, 0);
        q = B.length;
        ArrayList < Integer > res = new ArrayList < > ();
        for (int i = 0; i < q; i++) {

            String type = B[i];

            if (type.charAt(0) == 'C') {
                update(0, n - 1, C[i] - 1, C[i] - 1, 0, isPrime[D[i]] == true ? 1 : 0);
            } else {
                res.add(geta(0, n - 1, C[i] - 1, D[i] - 1, 0));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

	public static void main(String[] args) {
		CountPrime cp = new CountPrime();
		int A[] = {1, 3, 121, 20, 17, 26, 29};
		String B[] = {"A", "C", "A"};
		int C[] = {1, 3,  1};
		int D[] = {7, 19, 7};
		int ans[]=cp.solve(A,B,C,D);
		for(int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
	}

}
