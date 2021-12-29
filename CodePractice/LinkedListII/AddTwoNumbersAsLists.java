/**
 Q2. Add Two Numbers as Lists
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given two linked lists, A and B representing two non-negative numbers.

The digits are stored in reverse order and each of their nodes contain a single digit.

Add the two numbers and return it as a linked list.



Problem Constraints

1 <= |A|, |B| <= 105



Input Format

The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format

Return a pointer to the head of the required linked list.



Example Input

Input 1:

 
 A = [2, 4, 3]
 B = [5, 6, 4]
Input 2:

 
 A = [9, 9]
 B = [1]


Example Output

Output 1:

 
 [7, 0, 8]
Output 2:

 
 [0, 0, 1]


Example Explanation

Explanation 1:

 A = 342 and B = 465. A + B = 807. 
Explanation 2:

 A = 99 and B = 1. A + B = 100. 
*/

package LinkedListII;

class AddTwoNumbersAsLists {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static ListNode create(ListNode head, int x) {
		ListNode temp, ptr = head;
		temp = new ListNode(x);
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

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode p = a;
		ListNode q = b;
		ListNode r = null;
		ListNode tmp = null;
		ListNode curr = null;
		int o = 0;
		while (p != null || q != null) {
			int s1 = 0;
			if (p != null) {
				s1 = p.val;
				p = p.next;
			}
			int s2 = 0;
			if (q != null) {
				s2 = q.val;
				q = q.next;
			}
			int s = s1 + s2 + o;
			o = (s > 9) ? s / 10 : 0;
			s = s % 10;
			tmp = new ListNode(s);
			if (curr != null) {
				curr.next = tmp;
			} else {
				r = tmp;
			}
			curr = tmp;
			if (p == null && q == null && o > 0) {
				tmp = new ListNode(o);
				curr.next = tmp;
			}
		}
		return r;
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
		AddTwoNumbersAsLists mtsl = new AddTwoNumbersAsLists();
		ListNode head1 = null;

		head1 = create(head1, 2);
		head1 = create(head1, 4);
		head1 = create(head1, 3);
		ListNode head2 = null;

		head2 = create(head2, 5);
		head2 = create(head2, 6);
		head2 = create(head2, 4);

		ListNode head = mtsl.addTwoNumbers(head1, head2);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}