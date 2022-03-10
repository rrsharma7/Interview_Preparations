package designpatterns.singleton;

public class Client {

    public static void main(String[] args) {
        MyClass4 myClass4 = MyClass4.getInstance();

        MyClass4 myClass41 = MyClass4.getInstance();

        MyClass5 obj = MyClass5.INSTANCE;
        obj.printHello();
    }
}

// Serialization


// Singleton
// 1. Shared Resource
// 2. No state