package designpatterns.singleton;

public class MyClass3 {
    private static MyClass3 instance = new MyClass3();

    private MyClass3() {}

    public static MyClass3 getInstance() {
        return instance;
    }
}
