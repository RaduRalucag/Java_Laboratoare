package task4;

public class Task4Main {
    public static void main(String[] args) {
        foo();
    }
    public static void foo() {
        try {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        }finally {
            System.out.println("2");
        }

        System.out.println("3");
    }
}
