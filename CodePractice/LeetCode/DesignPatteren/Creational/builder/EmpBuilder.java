package LeetCode.DesignPatteren.Creational.builder;

public class EmpBuilder {
	private String firstName;
	private String lastName;
	private String address;

	public EmpBuilder getFirstName() {
		return this;
	}

	public EmpBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public EmpBuilder getLastName() {
		return this;
	}

	public EmpBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public EmpBuilder getAddress() {
		return this;
	}

	public EmpBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public Employee getEmployee() {
		return new Employee(firstName, lastName, address);

	}

}
