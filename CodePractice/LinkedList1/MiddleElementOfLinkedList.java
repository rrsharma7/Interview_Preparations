/**
Q2. Middle element of linked list
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a linked list of integers. Find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints

1 <= length of the linked list <= 100000

1 <= Node value <= 109



Input Format

The only argument given head pointer of linked list.



Output Format

Return the middle element of the linked list.



Example Input

Input 1:

 1 -> 2 -> 3 -> 4 -> 5
Input 2:

 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.


*/

package LinkedList1;

class MiddleElementOfLinkedList {

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

	public int solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public static void main(String args[]) {
		MiddleElementOfLinkedList rl = new MiddleElementOfLinkedList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);

		System.out.print("Linked list before modification: \n");
		int x = rl.solve(head);
		System.out.println(x);
	}
}