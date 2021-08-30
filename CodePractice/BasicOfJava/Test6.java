package test;

public class Test6 {

	public int numSetBits(int A) {
		int count = 0;
		while (A > 0) {
			int temp = A % 2;
			if (temp != 0)
				count++;
			A = A / 2;
		}
		return count;
	}

	public static void main(String[] args) {
		Test6 test5 = new Test6();
		int count = test5.numSetBits(8);
		System.out.println("count=" + count);
	}

}
