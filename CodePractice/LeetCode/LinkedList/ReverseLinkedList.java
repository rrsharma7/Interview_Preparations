
package LeetCode.LinkedList;

class ReverseLinkedList {

	
	
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

	//TC - O(N) SC - O(1)
	public ListNode reverseList(ListNode node) {
		ListNode prev = null;
		ListNode currentNode = node;
		while (currentNode != null) {
			ListNode temp = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = temp;
		}
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
		ReverseLinkedList krll = new ReverseLinkedList();
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

		head = krll.reverseList(head);
		System.out.print("Linked list after modification: \n");
		display(head);
	}
}