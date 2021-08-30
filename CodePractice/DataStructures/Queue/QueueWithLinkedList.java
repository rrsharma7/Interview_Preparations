package javachampion;

class QNode {
	int data;
	QNode next;

	public QNode(int data) {
		this.data = data;
		this.next = null;
	}
}

class Queue {
	QNode head;
	QNode rear;

	public Queue() {
		this.head = this.rear = null;
	}

	void enqueue(int data) {
		QNode toAdd = new QNode(data);
		if (this.rear == null) {
			this.head = this.rear = toAdd;
			return;
		}
		this.rear.next = toAdd;
		this.rear = toAdd;
	}

	void dequeue() {
		if (this.head == null) {
			return;
		}
		QNode temp = this.head;
		this.head = this.head.next;
		if (this.head == null)
			this.rear = null;
	}
}

public class QueueWithLinkedList {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue head : " + q.head.data);
		System.out.println("Queue Rear : " + q.rear.data);
	}
}
