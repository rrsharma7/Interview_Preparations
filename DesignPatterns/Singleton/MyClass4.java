package designpatterns.singleton;

public class MyClass4 {
    private static MyClass4 instance = null;

    private MyClass4() {}

    public static MyClass4 getInstance() {
        if (instance == null) {
            synchronized(MyClass4.class) {
                if (instance == null) {
                    instance = new MyClass4();
                }
            }
        }

        return instance;
    }
}
