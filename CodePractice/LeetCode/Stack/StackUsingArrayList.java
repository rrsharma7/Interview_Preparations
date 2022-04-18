package LeetCode.Stack;

public class StackUsingArrayList {

	static int max = 4;
	static int arr[] = new int[max];
	int top;

	public StackUsingArrayList() {
		top = -1;
	}

	private boolean push(int data) {
		if (top >= max - 1) {
			System.out.println("stack overflow");
			return false;
		} else {
			++top;
			arr[top] = data;
			return true;
		}

	}

	private int pop() {
		if (top < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {
			int x = arr[top--];
			return x;
		}
	}

	private int peek() {
		if (top < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {
			int x = arr[top];
			return x;
		}
	}

	public static void main(String[] args) {
		StackUsingArrayList stackUsingArrayList = new StackUsingArrayList();
		stackUsingArrayList.push(10);
		stackUsingArrayList.push(20);
		stackUsingArrayList.push(30);
		stackUsingArrayList.push(40);
		System.out.println(stackUsingArrayList.pop() + " Popped from stack");
		System.out.println(stackUsingArrayList.peek());
		System.out.println(stackUsingArrayList.pop());
		System.out.println(stackUsingArrayList.peek());

	}

}