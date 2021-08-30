package problemsolving2;

public class EquilibriumIndex {

	public int solve(int[] A) {
		int n = A.length;
		int prefixSum[] = new int[n];
		prefixSum[0] = A[0];
		for (int i = 1; i < n; ++i)
			prefixSum[i] = prefixSum[i - 1] + A[i];
		int i = 0;
		for (i = 1; i < n - 1; ++i)
			if (prefixSum[i - 1] == prefixSum[n - 1] - prefixSum[i])
				if(i==1) {
					return i-1;}
				else{return i;}
		return -1;

	}

	public static void main(String[] s) {
		EquilibriumIndex equilibriumIndex = new EquilibriumIndex();
		int nums[] = { -7, 1, 5, 2, -4, 3, 0  };
		int x = equilibriumIndex.solve(nums);
		System.out.println(x);
	}
}
