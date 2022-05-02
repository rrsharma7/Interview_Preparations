package LeetCode.DesignPatteren.Creational;

interface Vehicle {

	void engine();
}

class BMW implements Vehicle {

	public void engine() {
		System.out.println("BMW Engine");

	}

}

class Alto implements Vehicle {

	public void engine() {
		System.out.println("Alto Engine");
	}

}

class VehicleFactory extends AbstractFactory {
	@Override
	public Vehicle create(int carType) {
		Vehicle b = null;
		if (carType == 1) {
			b = new BMW();
		} else if (carType == 2) {
			b = new Alto();
		}
		return b;
	}

}

abstract class AbstractFactory {
	public abstract Vehicle create(int carType);
}

class FactoryProvider {
	public static AbstractFactory getFactory(String choice) {
		if ("Vehicle".equalsIgnoreCase(choice)) {
			return new VehicleFactory();
		}
		return null;
	}
}

public class AbstractFactoryy {
	public static void main(String args[]) {
		AbstractFactory vehicleFactory = FactoryProvider.getFactory("Vehicle");
		Vehicle v = vehicleFactory.create(1);
		v.engine();
		v = vehicleFactory.create(2);
		v.engine();
	}

}
