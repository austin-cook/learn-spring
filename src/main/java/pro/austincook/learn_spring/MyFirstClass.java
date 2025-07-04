package pro.austincook.learn_spring;


public class MyFirstClass {
    private final String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from my first class ==> myVar = " + myVar;
    }
}
