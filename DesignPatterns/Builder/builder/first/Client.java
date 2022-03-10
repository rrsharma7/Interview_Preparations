package designpatterns.builder.first;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<ParamaterValues, Object> map = new HashMap<>();
        map.put(ParamaterValues.Age, "Hello");

        Student st = new Student(map);
    }
}
