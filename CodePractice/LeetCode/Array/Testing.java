package LeetCode.Array;

interface T1 {

	static void neha() {
		System.out.println("neha");
	}
}

public class Testing implements T1 {

	
	public void neha() {
		System.out.println("neha1");
		T1.neha();
		
		
	}
	public static void main(String[] args) {
		Testing t1 = new Testing();
		t1.neha();
		

	}

}

//1,2,3,4,5,6,7

//5671234