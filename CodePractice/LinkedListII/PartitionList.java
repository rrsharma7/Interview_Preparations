/**
 Q2. Partition List

Problem Description

Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.



Problem Constraints

1 <= |A| <= 106

1 <= A[i], B <= 109



Input Format

The first argument of input contains a pointer to the head to the given linked list.

The second argument of input contains an integer, B.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

A = [1, 4, 3, 2, 5, 2]
B = 3
Input 2:

A = [1, 2, 3, 1, 3]
B = 2


Example Output

Output 1:

[1, 2, 2, 4, 3, 5]
Output 2:

[1, 1, 2, 3, 3]


Example Explanation

Explanation 1:

 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
Explanation 2:

 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.

*/

package LinkedListII;

class PartitionList {

	static class ListNode {
		int val;
		ListNode next;
	};

	static ListNode create(ListNode head, int x) {
		ListNode temp, ptr = head;
		temp = new ListNode();
		temp.val = x;
		temp.next = null;
		if (head == null)
			head = temp;
		else {
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = temp;
		}
		return head;
	}

	public ListNode partition(ListNode A, int B) {
		ListNode firstpart = null;
		ListNode secondpart = null;
		ListNode firstpartIterator = null;
		ListNode secondpartIterator = null;
		ListNode temp = A;
		while (temp != null) {
			if (temp.val < B) {
				if (firstpart == null) {
					firstpart = temp;
					firstpartIterator = temp;
				} else {
					firstpartIterator.next = temp;
					firstpartIterator = firstpartIterator.next;
				}
			} else {
				if (secondpart == null) {
					secondpart = temp;
					secondpartIterator = temp;
				} else {
					secondpartIterator.next = temp;
					secondpartIterator = secondpartIterator.next;
				}
			}
			temp = temp.next;
		}
		if (firstpartIterator == null)
			return secondpart;
		if (secondpartIterator == null)
			return firstpart;
		firstpartIterator.next = secondpart;
		secondpartIterator.next = null;
		return firstpart;
	}

	static void display(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		PartitionList pl = new PartitionList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 4);
		head = create(head, 3);
		head = create(head, 2);
		head = create(head, 5);
		head = create(head, 2);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = pl.partition(head, 3);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}