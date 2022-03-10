package designpatterns.singleton;

public class MyClass2 {
    private static MyClass2 instance = null;

    private MyClass2() {}

    public synchronized static MyClass2 getInstance() {
        if (instance == null) {
            instance = new MyClass2();
        }

        return instance;
    }
}
