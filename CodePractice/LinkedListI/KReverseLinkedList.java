/**
 Q2. K reverse linked list

Problem Description

Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return modified linked list.



Problem Constraints

1 <= |A| <= 103

B always divides A



Input Format

The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output

Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation

Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]

*/

package LinkedListI;

class KReverseLinkedList {

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

	public ListNode reverseList(ListNode A, int B) {
		ListNode prev = null;
		ListNode curr = A;
		ListNode temp = null;
		int count = 0;
		while (count < B && curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count++;
		}
		if(temp!=null)
		A.next=reverseList(temp,B);
		return prev;
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
		KReverseLinkedList krll = new KReverseLinkedList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);
		head = create(head, 6);
		head = create(head, 7);
		head = create(head, 8);
		head = create(head, 9);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = krll.reverseList(head, 3);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}