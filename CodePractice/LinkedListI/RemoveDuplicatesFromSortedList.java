/**
Q3. Remove Duplicates from Sorted List

Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.



Problem Constraints

0 <= length of linked list <= 106



Input Format

First argument is the head pointer of the linked list.



Output Format

Return the head pointer of the linked list after removing all duplicates.



Example Input

Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output

Output 1:

 1->2
Output 2:

 1->2->3


Example Explanation

Explanation 1:

 Each element appear only once in 1->2.


*/

package LinkedListI;

class RemoveDuplicatesFromSortedList {

	static class ListNode {
		int data;
		ListNode next;
	};

	static ListNode create(ListNode head, int x) {
		ListNode temp, ptr = head;
		temp = new ListNode();
		temp.data = x;
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

	public ListNode deleteDuplicates(ListNode A) {
		/* Another reference to head */
		ListNode curr = A;

		/* Traverse list till the last node */
		while (curr != null) {
			ListNode temp = curr;
			/*
			 * Compare current node with the next node and keep on deleting them until it
			 * matches the current node data
			 */
			while (temp != null && temp.data == curr.data) {
				temp = temp.next;
			}
			/*
			 * Set current node next to the next different element denoted by temp
			 */
			curr.next = temp;
			curr = curr.next;
		}
		return A;

	}

	static void display(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 1);
		head = create(head, 2);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = rdfsl.deleteDuplicates(head);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}