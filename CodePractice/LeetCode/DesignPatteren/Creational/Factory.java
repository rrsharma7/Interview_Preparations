package LeetCode.DesignPatteren.Creational;


interface Vehicle1 {

	void engine();

}

class BMW1 implements Vehicle1 {

	public void engine() {
		System.out.println("BMW Engine");

	}

}

class Alto1 implements Vehicle1 {

	public void engine() {
		System.out.println("Alto Engine");
	}

}

class VehicleFactory1 {
	public Vehicle1 getInstance(int carType) {
		Vehicle1 b = null;
		if (carType == 1) {
			b = new BMW1();
		} else if (carType == 2) {
			b = new Alto1();
		}
		return b;
	}

}

public class Factory {
	public static void main(String args[]) {
		VehicleFactory1 vehicleFactory = new VehicleFactory1();
		Vehicle1 v = vehicleFactory.getInstance(1);
		v.engine();
		v = vehicleFactory.getInstance(2);
		v.engine();
	}

}
