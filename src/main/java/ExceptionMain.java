public class ExceptionMain {
    public static void main(String[] args) {
        try {
            throw new JustMyFirstException();
        } catch (Exception JustMyFirstException) {
            System.out.println(JustMyFirstException.getMessage());
        }
    }
}
