package LeetCode.DesignPatteren.Creational;

public class Prototype implements Cloneable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]) {
		Prototype pt = new Prototype();
		pt.setName("rahul");
		try {
			Prototype pt1 = (Prototype) pt.clone();
			System.out.println(pt1.getName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
