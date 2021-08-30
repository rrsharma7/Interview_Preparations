package problemsolving2;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingMaximum {

	public int[] slidingMaximum(final int[] A, int B) {
        if (B == 1)
			return A;
		int[] result = new int[A.length - B + 1];
		int start = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int end = 0; end < A.length; end++) {
			while (!deque.isEmpty() && A[end] > A[deque.peekLast()]) {
				deque.pollLast();
			}
    		deque.addLast(end);
			if (end - start + 1 == B) {
				if (deque.peekFirst() < start)
					deque.pollFirst();
				result[start++] = A[deque.peekFirst()];
			}
		}
		return result;
    }

	public static void main(String[] s) {
		SlidingMaximum sm = new SlidingMaximum();
		int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] result =sm.slidingMaximum(nums,3);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(""+result[i]+" ");
		}
		
		
	}
}
