package extra.basic;

public class StaticFactoryMethod {
    public static void main(String[] args) {
        Test1 o1 = new Test1("siwei", 23);
        Test1 o2 = new Test1("siwei2", 24);

        Test1 o3 = Test1.valueOf("siwei", 23);
        Test1 o4 = Test1.valueOf("siwei4", 23);
        System.out.println(o1.equals(o2));
        System.out.println(o3.equals(o4));

    }
}
