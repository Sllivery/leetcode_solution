package extra.basic;

public class Test1 {
    private String name;
    private int age;

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Test1 valueOf(String name, int age) {
        return new Test2(name, age);
    }
}

class Test2 extends Test1{

    public Test2(String name, int age) {
        super(name, age);
    }
}
