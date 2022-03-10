package designpatterns.singleton;

public class MyClass1 {
    private static MyClass1 instance = null;

    private MyClass1() {}

     public static MyClass1 getInstance() {
        if (instance == null) {
            instance = new MyClass1();
        }

        return instance;
     }
}
