/**
Q3. Reorder List

Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints

1 <= |A| <= 106



Input Format

The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output

Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation

Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2]

*/

package LinkedList1;

class ReorderList {

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

	 public ListNode reorderList(ListNode n) {
	        if(n == null || n.next == null || n.next.next == null) {
	            return n;
	        }
	        ListNode middle = getMiddleNode(n);
	        ListNode temp2 = reverseList(middle.next);
	        middle.next = null;
	        ListNode temp1 = n;
	        while(temp1 != null && temp2 != null) {
	            ListNode temp3 = temp2;
	            temp2 = temp2.next;
	            temp3.next = temp1.next;
	            temp1.next = temp3;
	            temp1 = temp3.next;
	        }
	        return n;
	    }
	    
	    private ListNode reverseList(ListNode n) {
	        if(n == null) return null;
	        ListNode pre = null;
	        ListNode cur = n;
	        ListNode nextn = null;
	        while(cur != null) {
	            nextn = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = nextn;
	        }
	        return pre;
	    }
	    
	    private ListNode getMiddleNode(ListNode n) {
	        if(n == null) return null;
	        ListNode slow = n;
	        ListNode fast = n.next;
	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next;
	            if(fast != null)
	                fast = fast.next;
	        }
	        return slow;
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
		ReorderList rl = new ReorderList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = rl.reorderList(head);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}