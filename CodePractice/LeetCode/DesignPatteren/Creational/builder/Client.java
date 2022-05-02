package LeetCode.DesignPatteren.Creational.builder;

public class Client {

	public static void main(String args[]) {
//		Employee employee = new Employee("rahul", "sharma", "abs");
//		System.out.println(employee.getFirstName());
		Employee employee=new EmpBuilder().setFirstName("rahul").getEmployee();
		System.out.println(employee.getFirstName());
	}

}
