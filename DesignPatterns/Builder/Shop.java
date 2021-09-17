package Builder;

public class Shop {

	public static void main(String[] args) {
		Phone p = new PhoneBuilder().setOs("Android").getPhone();
		System.out.println(p);
	}

}
