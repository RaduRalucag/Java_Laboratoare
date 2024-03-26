package task5;

public class Task5Main {
    public static void main(String[] args) {
        bar();
    }
    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            if(e instanceof ClassCastException) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        }
    }
}
