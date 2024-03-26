package SmarterCalculator;

public class InvalidOperationException extends CalculatorException{
    public InvalidOperationException(String operation) {
        super("Invalid operation: " + operation);
    }
}
