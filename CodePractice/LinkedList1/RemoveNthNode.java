/**
 Q1. Remove Nth Node from List End

Problem Description

Given a linked list A, remove the B-th node from the end of list and return its head.

For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

NOTE: Try doing it using constant additional space.



Problem Constraints

1 <= |A| <= 106



Input Format

The first argument of input contains a pointer to the head of the linked list.

The second argument of input contains the integer B.



Output Format

Return the head of the linked list after deleting the B-th element from the end.



Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 2
Input 2:

A = [1]
B = 1


Example Output

Output 1:

[1, 2, 3, 5]
Output 2:

 [] 


Example Explanation

Explanation 1:

In the first example, 4 is the second last element.
Explanation 2:

In the second example, 1 is the first and the last element.

*/

package LinkedList1;

import java.util.Stack;

class RemoveNthNode {

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

	public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode p=A;
        ListNode q=A;
        while(B>0){
            p=p.next;
            if(p==null)
            {
                return A.next;
            }
            B--;
        }
       
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
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
		RemoveNthNode rnn = new RemoveNthNode();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);

		int n = 2;

		System.out.print("Linked list before modification: \n");
		display(head);

		head = rnn.removeNthFromEnd(head, 2);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}