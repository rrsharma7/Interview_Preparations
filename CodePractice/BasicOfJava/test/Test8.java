// First sort array
package test;

public class Test8 {

	public String[] fizzBuzz(int A) {
		String[] arr = new String[A];
		int count=0;
		for (int i = 1; i <=A; i++) {
			 arr[count]=String.valueOf(i);
			if (i % 3 == 0 && i%5!=0) {
				arr[count] = "Fizz";
			} else if (i % 5 == 0 && i%3!=0) {
				arr[count] = "Buzz";
			} else if (i % 3 == 0 && i % 5 == 0) {
				arr[count] = "FizzBuzz";
			}
            count++;
		}
		return arr;
	}

	public static void main(String[] args) {
		Test8 test8 = new Test8();
		String str[] = test8.fizzBuzz(15);
		for (int i = 0; i <str.length; i++) {
			System.out.println("f------------"+str[i]);
		}

	}

}
