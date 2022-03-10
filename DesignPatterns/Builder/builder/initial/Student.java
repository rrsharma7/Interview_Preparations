package designpatterns.builder.initial;

public class Student {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;

    Student(String name,
            String email,
            String phone,
            String pass,
            String address,
            int age
            ) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.pass = pass;
        this.email = email;
    }
}
