package SmarterCalculator;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException{
    public InvalidArgumentsLengthException(int expected, int actual) {
        super("Invalid number of arguments. Expected: " + expected + ", actual: " + actual);
    }
}
