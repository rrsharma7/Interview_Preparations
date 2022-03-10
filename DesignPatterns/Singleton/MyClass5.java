package designpatterns.singleton;

public enum MyClass5 {
    INSTANCE("Naman");

    private String name;

    MyClass5(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello " + this.name);
    }
}


// INSTANCE = new MyClass5();
