package LeetCode.DesignPatteren.Creational;

class Test {

	private static Test test = null;
	private Test() {
	}
	public static Test getInstance() {
		if (test == null) {
			System.out.println("Singelton");
			test = new Test();
		}
		return test;
	}

}

public class Singelton {
	public static void main(String args[]) {
		Test.getInstance();
		Test.getInstance();
		Test.getInstance();
		Test.getInstance();
	}

}
