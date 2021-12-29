/**
 Q1. Reverse Link List II

Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format

The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output

Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation

Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 


*/

package LinkedListI;

class ReverseLinkListII {

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

	public ListNode reverseBetween(ListNode A, int m, int n) {
        int i;
        ListNode node = A;
        ListNode prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    public ListNode reverseList(ListNode A, int count) {
        ListNode node, prev, temp, last;
        node = A;
        last = A;
        if (node == null)
            return null;
        prev = null;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        last.next = node;
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
		ReverseLinkListII rll = new ReverseLinkListII();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = rll.reverseBetween(head, 1, 5);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}