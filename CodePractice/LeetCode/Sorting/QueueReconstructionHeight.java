package Leetcode.Sorting;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueueReconstructionHeight {

	public int[][] reconstructQueue(int[][] people) {
		// If same height, sort by idx ascending, otherwise sort by height descending
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> result = new ArrayList<>();
		for (int[] person : people) {
			System.out.println(person[0] + " " + person[1]);
			result.add(person[1], person);
			/*
			 * adding element at person[1] index , i.e. we are reordering the linked list in
			 * each iteration say for 7 0 7 1 6 1 5 0 5 2 4 4 (7,0) would be placed at 0th
			 * index , (7,1) at 1st index , (6,1) is now added at 1st index and (7,1) is
			 * moved to index 2 similarly for (5,0) , it is added at 0th index and rest of
			 * the lists is shifted
			 * 
			 */
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		QueueReconstructionHeight qch = new QueueReconstructionHeight();
		int[][] A = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] ans = qch.reconstructQueue(A);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println(); // change line on console as row comes to end in the matrix.
		}

	}

}
