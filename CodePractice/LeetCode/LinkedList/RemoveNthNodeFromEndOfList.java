
package LeetCode.LinkedList;

class RemoveNthNodeFromEndOfList {

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int data) {
			this.data = data;
			next = null;
		}

		public ListNode() {
		}
	}

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

	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode dummy=new ListNode(-1);
		 dummy.next=head;
		 ListNode first=dummy;
		 ListNode second=dummy;
		 while(n-->=0)
			first=first.next;
		 while(first!=null) {
			 first=first.next;
			 second=second.next;
		 }
		 second.next=second.next.next;
		return dummy.next;
	        
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
		RemoveNthNodeFromEndOfList rnnode = new RemoveNthNodeFromEndOfList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);

		System.out.print("Linked list before modification: \n");
		display(head);

		head = rnnode.removeNthFromEnd(head,2);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}