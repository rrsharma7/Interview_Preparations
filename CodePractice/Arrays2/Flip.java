package Arrays2;

import java.util.ArrayList;

class Flip {

	public ArrayList<Integer> flip(String A) {
		int max = 0;
		int leftIndex = -1;
		int rightIndex = -1;
		int currMax = 0;
		int maxLeftIndex = -1;
		int maxRightIndex = -1;
		int currIndex = 1;
		for (char ch : A.toCharArray()) {
			if (ch == '0') {
				currMax += 1;
				if (leftIndex == -1) {
					leftIndex = rightIndex = currIndex;
				}
			} else if (ch == '1') {
				currMax -= 1;
				if (currMax < 0) {
					currMax = 0;
					leftIndex = -1;
					rightIndex = -1;
				}
			}
			if (currMax > max) {
				max = currMax;
				maxLeftIndex = leftIndex;
				maxRightIndex = currIndex;

			}
			currIndex += 1;

		}
		ArrayList<Integer> result = new ArrayList<>();
		if (maxLeftIndex != -1) {
			result.add(maxLeftIndex);
			result.add(maxRightIndex);

		}

		return result;
	}

	public static void main(String[] args) {
		Flip flip = new Flip();
		flip.flip("010");
	}
}
