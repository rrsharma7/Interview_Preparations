package LeetCode.LinkedList;

import java.util.*;

public class RemoveLoopFromLinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	// Function to print the linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	static boolean removeLoop(Node curr) {
		HashSet<Node> s = new HashSet<Node>();
		Node prev = null;
		while (curr != null) 
		{
			if (s.contains(curr)) {
				prev.next = null;
				return true;
			}
			else {
				s.add(curr);
				prev = curr;
				curr = curr.next;
			}
		}

		return false;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		RemoveLoopFromLinkedList llist = new RemoveLoopFromLinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		if (removeLoop(head)) {
			System.out.println("Linked List after removing loop");
			llist.printList(head);
		} else
			System.out.println("No Loop found");
	}
}

//This code is contributed by Animesh Nag.
