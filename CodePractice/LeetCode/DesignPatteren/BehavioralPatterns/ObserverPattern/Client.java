package LeetCode.DesignPatteren.BehavioralPatterns.ObserverPattern;

public class Client {

	public static void main(String[] args) {
		DeliveryData topic = new DeliveryData();

		Observer obj1 = new SellerObserver();
		Observer obj2 = new UserObserver();
		Observer obj3 = new DeliveryWarehouseCenterObserver();

		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);

		topic.locationChanged();

		topic.unregister(obj3);

		System.out.println();
		topic.locationChanged();

	}
}