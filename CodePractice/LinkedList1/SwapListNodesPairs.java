/**
 Q4. Swap List Nodes in pairs

Problem Description

Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.



Problem Constraints

1 <= |A| <= 106



Input Format

The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4
Input 2:

 A = 7 -> 2 -> 1


Example Output

Output 1:

 2 -> 1 -> 4 -> 3
Output 2:

 2 -> 7 -> 1


Example Explanation

Explanation 1:

 In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
Explanation 2:

 In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 


*/

package LinkedList1;

class SwapListNodesPairs {

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

	public ListNode swapPairs(ListNode A) {
		if (A==null) return A;
        ListNode first = A;
        ListNode prev = A;
        while(first!=null && first.next!=null){
            int temp = prev.val;
            prev.val = first.next.val;
            first.next.val = temp;
            first=first.next.next;
            prev = first;
        }
        return A;
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
		SwapListNodesPairs slnp = new SwapListNodesPairs();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = slnp.swapPairs(head);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}