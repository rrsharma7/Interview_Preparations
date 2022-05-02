package LeetCode.DesignPatteren.StructuralPatterns.FlyweightPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		List<FlyingBullet> bulletList = new ArrayList<>();
		Map<Integer, Bullet> type_bullet_map = new HashMap<>();

		for (int i = 0; i < 72000; ++i) {
			FlyingBullet flyingBullet = new FlyingBullet();
			flyingBullet.current_speed = 123; // coming from input
			flyingBullet.direction = 12;// coming from input
			flyingBullet.latitude = 1; // coming from input
			flyingBullet.longitude = 2; // coming from input
			flyingBullet.shotByUserId = 12345; // coming from input
			int caliber = 1234; // from input

			if (type_bullet_map.get(caliber) == null) {
				Bullet bullet = new Bullet();
				bullet.caliber = 1234; // from the input
				bullet.type = "somestring"; // from input
				bullet.damage = 1.234; // from input
				bullet.image = new byte[2000];
				bullet.weight = 5757;

				type_bullet_map.put(caliber, bullet);
			}

			flyingBullet.bullet = type_bullet_map.get(caliber);
			bulletList.add(flyingBullet);
		}

		int ad = 3;
	}
}