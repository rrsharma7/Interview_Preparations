package MathsModularArithmetic;

public class FindingPosition {

	public int solve(int A) {
		int result=1;
		while(result<=A/2)
		result=result*2;
		return result;
	}

	public static void main(String[] args) {
		FindingPosition fp = new FindingPosition();
		fp.solve(5);

	}
}
