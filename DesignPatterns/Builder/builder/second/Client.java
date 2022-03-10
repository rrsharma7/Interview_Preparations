package designpatterns.builder.second;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setAddress("ABC")
                .setAge(18)
                .setEmail("bcd")
                .setPass("fgh");

        Student st = new Student(builder);


        // a.setA().setB().setC().setD()
        // a.setB().setA()




//        Student st = new Student(map);
    }
}
