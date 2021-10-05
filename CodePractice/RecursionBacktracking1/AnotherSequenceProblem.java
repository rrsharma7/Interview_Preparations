package RecursionBacktracking1;

public class AnotherSequenceProblem {

	public int solve(int A) {
		if(A==2)
			return 2;
		else if(A==0 || A==1)
			return 1;
		int ans = solve(A - 1) + solve(A - 2) + solve(A - 3)+A;
		return ans;
	}

	public static void main(String[] s) {
		AnotherSequenceProblem asp = new AnotherSequenceProblem();
		int res = asp.solve(3);
		System.out.println(res);

	}
}
