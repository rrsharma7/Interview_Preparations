package arrays2;

class SumOfAllSubmatrices {

	public int solve(int[][] A) {
		int sum = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int top_left = (i + 1) * (j + 1);
				int bottom_right = (n - i) * (n - j);
				sum =sum+(top_left * bottom_right * A[i][j]);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		SumOfAllSubmatrices soas=new SumOfAllSubmatrices();
		int arr[][] = { { 1, 1 }, { 1, 1 } };
		System.out.println(soas.solve(arr));
	}
}
