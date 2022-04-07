package strategy_pattern;

import strategy_pattern.strategies.Role;

public class Employee {
    private int id;
    private String name;
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void promote(Role newRole) {
        role = newRole;
    }

    public String grade() {
        return this.name + " is a " + role.description();
    }

    public void doWork() {
        System.out.println(name + " Will " + role.responsibilities());
    }
}
