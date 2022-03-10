package designpatterns.builder.second;

import java.util.Map;

class Builder {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;

    public String getName() {
        return name;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Builder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Builder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Builder setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }
}

public class Student {
    private  String name;
    private  String email;
    private  String phone;
    private  String pass;
    private String address;
    private  int age;

    Student(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
    }

//    Student(Map<ParamaterValues, Object> values) {
//        this.address = (String) values.get(ParamaterValues.Address);
//        this.name = (String) values.get(ParamaterValues.Name);
//        this.age = age;
//        this.pass = pass;
//        this.email = email;
//    }
}
