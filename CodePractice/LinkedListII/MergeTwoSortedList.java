/**
 Q1. Merge Two Sorted Lists

Problem Description

Merge two sorted linked lists A and B and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.



Problem Constraints

0 <= |A|, |B| <= 105



Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the merged linked list.



Example Input

Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output

Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3


Example Explanation

Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 
Explanation 2:

 We don't need to merge as B is empty. 
*/

package LinkedListII;

class MergeTwoSortedList {

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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// low is pointing to always smaller value and high is pointing to greater
		// value.
		ListNode low = list1, high = list2;
		// head will be final list head and temp will merge the two list.
		ListNode head = null, temp = null;
		// If list1 is null then return list2 beacuse it is sorted.
		if (list1 == null) {
			return list2;
		}
		// If list2 is null then return list1 beacuse it is sorted.
		if (list2 == null) {
			return list1;
		}
		// If two lists are null then return null.
		if (list1 == null && list2 == null) {
			return null;
		}
		while (low != null && high != null) {
			// If head is null then put smaller value to it.
			if (head == null) {
				// If low is smaller than put it.
				if (low.val <= high.val) {
					head = low;
					temp = low;
					low = low.next;
				} else {
					// Else put high into head.
					head = high;
					temp = high;
					high = high.next;
				}
				continue;
			}

			// If low value is smaller than it will be the next of temp
			// Because temp will merger the lists.
			if (low.val <= high.val) {
				temp.next = low;
				temp = low;
				low = low.next;
			} else {
				// Otherwise swap low and high
				// Because low always pointing to smaller
				// high always pointing to the bigger.
				ListNode node = low;
				low = high;
				high = node;
			}
		}

		// If the loop terminate cause of pointing of high to null
		// Because there is a situation that low value is greater and
		// and list2 only contain one node then rest of low will be
		// added to next of temp.
		while (low != null) {
			temp.next = low;
			temp = low;
			low = low.next;
		}

		// If low is pointing to null then rest of the list2 will be
		// added to the next of the temp.
		while (high != null) {
			temp.next = high;
			temp = high;
			high = high.next;
		}

		// Finally return the head
		return head;
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
		MergeTwoSortedList mtsl = new MergeTwoSortedList();
		ListNode head1 = null;

		head1 = create(head1, 5);
		head1 = create(head1, 8);
		head1 = create(head1, 20);
		ListNode head2 = null;

		head2 = create(head2, 4);
		head2 = create(head2, 11);
		head2 = create(head2, 15);

		ListNode head = mtsl.mergeTwoLists(head1, head2);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}