package SmarterCalculator;

import SmarterCalculator.CalculatorException;

public class UnknownOperandTypeException extends CalculatorException {

    public UnknownOperandTypeException(String operation) {
        super("Unknown operand type in operation: " + operation);
    }
}
