package designpatterns.builder.first;

import java.util.Map;

public class Student {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;

    Student(Map<ParamaterValues, Object> values) {
        this.address = (String) values.get(ParamaterValues.Address);
        this.name = (String) values.get(ParamaterValues.Name);
        this.age = (Integer) values.get(ParamaterValues.Age) ;
        this.pass = pass;
        this.email = email;
    }
}
