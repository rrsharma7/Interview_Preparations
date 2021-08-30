package javachampion;

public class StackUsingArrayList {

	static int max = 4;
	int top;
	int a[] = new int[max];

	public StackUsingArrayList() {
		top = -1;
	}

	public boolean push(int x) {
		if (top >= max - 1) {
			System.out.println("stack overflow");
			return false;
		} else {
			++top;
			a[top] = x;
			return true;
		}

	}

	public int peek() {
		if (top < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {

			int x = a[top];
			return x;
		}

	}

	public int pop() {
		if (top < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {

			int x = a[top--];
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