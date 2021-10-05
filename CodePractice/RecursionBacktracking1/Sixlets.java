package RecursionBacktracking1;

class Sixlets {

	int sixlets(int a[], int i, int sum, int cnt) {
		if (sum > 1000)
			return 0;
		if (cnt == 0)
			return 1;
		if (i == a.length)
			return 0;
		return sixlets(a, i + 1, sum, cnt) + sixlets(a, i + 1, sum + a[i], cnt -1);
	}

	public int solve(int[] A, int B) {
		return sixlets(A, 0, 0, B);
	}
	public static void main(String[] args) {
		Sixlets sixlets=new Sixlets();
		int arr[] = { 1, 2, 8 };
		System.out.print(sixlets.solve(arr, 2));
	}
}

