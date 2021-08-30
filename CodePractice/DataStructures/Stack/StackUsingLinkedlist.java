package javachampion;

import static java.lang.System.exit;

class StackUsingLinkedlist {
	Node top;

	private class Node {
		int data;
		Node link;
	}

	StackUsingLinkedlist() {
		top = null;
	}

	public void push(int x) {
		Node temp = new Node();
		if (temp == null) {
			return;
		} else {
			temp.data = x;
			temp.link = top;
			top = temp;
		}

	}

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			return top.data;
		}

	}

	public void pop() {
		if (isEmpty()) {
			return;
		} else {
			top = (top).link;
		}

	}

	public void display() {
		if (top == null) {
			System.out.printf("\nStack Underflow");
			exit(1);
		} else {
			Node temp = top;
			while (temp != null) {
				System.out.println("display data=" + temp.data);
				temp = temp.link;
			}
		}

	}

	public static void main(String[] args) {
		// create Object of Implementing class
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		// insert Stack value
		obj.push(11);
		obj.push(22);
		obj.push(33);
		obj.push(44);

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n", obj.peek());

		// Delete top element of Stack
		obj.pop();
		obj.pop();

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.printf("\nTop element is %d\n", obj.peek());
	}
}