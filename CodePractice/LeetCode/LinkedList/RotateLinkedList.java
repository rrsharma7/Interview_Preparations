
package LeetCode.LinkedList;

class RotateLinkedList {

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

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k==0)
			return head;
		ListNode temp = head;
		int c = 1;
		while (temp.next != null) {
			c++;
			temp = temp.next;
		}
		k = k % c;
		temp.next = head; //12345
		for (int i = 0; i < c - k; i++)
		{
			temp = temp.next; //123
		}
		head = temp.next; 
		temp.next = null;
		return head;
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
		RotateLinkedList krll = new RotateLinkedList();
		ListNode head = null;

		head = create(head, 1);
		head = create(head, 2);
		head = create(head, 3);
		head = create(head, 4);
		head = create(head, 5);


		System.out.print("Linked list before modification: \n");
		display(head);

		head = krll.rotateRight(head,2);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}