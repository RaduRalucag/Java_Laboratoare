package lab1.task4;

import java.util.Scanner;

public class DummyCalculator {

    public void calculate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Introduceti operatia: ");
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                break;
            }

            String[] args = input.split(" ");
            if (args.length != 3) {
                System.out.println("Format gresit");
                continue;
            }

            Object operand1 = parseOperand(args[0]);
            String operator = args[1];
            Object operand2 = parseOperand(args[2]);

            Object result = performOperation(operand1, operator, operand2);

            System.out.println("Rezultat: " + result);
        }
        scanner.close();
    }

    private Object parseOperand(String operand) {
        if (operand.equalsIgnoreCase("true") || operand.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(operand);
        } else {
            return Double.parseDouble(operand);
        }
    }

    private Object performOperation(Object operand1, String operator, Object operand2) {
        if (operand1 instanceof Boolean && operand2 instanceof Boolean) {
            return performBooleanOperation((boolean) operand1, operator, (boolean) operand2);
        } else if (operand1 instanceof Double || operand2 instanceof Double) {
            double result = performDoubleOperation((double) operand1, operator, (double) operand2);
            return result;
        } else if (operand1 instanceof Integer && operand2 instanceof Integer) {
            return performIntegerOperation((int) operand1, operator, (int) operand2);
        } else {
            throw new IllegalArgumentException("Tipurile de operanzi nu sunt compatibile");
        }
    }

    private boolean performBooleanOperation(boolean operand1, String operator, boolean operand2) {
        switch (operator) {
            case "&&":
                return operand1 && operand2;
            case "||":
                return operand1 || operand2;
            default:
                throw new IllegalArgumentException("Operator gresit");
        }
    }

    private double performDoubleOperation(double operand1, String operator, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Nu se poate imparti la 0");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operator gresit");
        }
    }

    private int performIntegerOperation(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Nu se poate imparti la 0");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operator gresit");
        }
    }

}
