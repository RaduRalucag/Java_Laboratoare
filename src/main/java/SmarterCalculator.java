import java.util.ArrayList;
import java.util.List;

class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> requests = InputConverter.mapRequests(args);
        List<CalculatorResult> results = new ArrayList<>();

        for (CalculatorRequest request : requests) {
            if (!request.getRequestType().equals("Invalid")) {
                switch (request.getRequestType()) {
                    case "Integer":
                        results.add(new IntegerCalculatorResult(request));
                        break;
                    case "Double":
                        results.add(new DoubleCalculatorResult(request));
                        break;
                    case "Boolean":
                        results.add(new BooleanCalculatorResult(request));
                        break;
                }
            }
        }

        return results;
    }
}

class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }

    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public String getRequestType() {
        if (leftOperand instanceof Integer && rightOperand instanceof Integer) {
            return "Integer";
        } else if (leftOperand instanceof Double && rightOperand instanceof Double) {
            return "Double";
        } else if (leftOperand instanceof Boolean && rightOperand instanceof Boolean) {
            return "Boolean";
        }
        return "Invalid";
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }
}

class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> requests = new ArrayList<>();
        for (int i = 0; i < args.length; i += 3) {
            Object leftOperand = parseOperand(args[i]);
            String operation = args[i + 1];
            Object rightOperand = parseOperand(args[i + 2]);
            if (leftOperand != null && rightOperand != null) {
                requests.add(new CalculatorRequest(leftOperand, rightOperand, operation));
            }
        }
        return requests;
    }

    private static Object parseOperand(String operand) {
        try {
            if (operand.contains(".")) {
                return Double.parseDouble(operand);
            } else if (operand.equalsIgnoreCase("true") || operand.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(operand);
            } else {
                return Integer.parseInt(operand);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return null;
        }
    }
}

abstract class CalculatorResult {
    private CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }

    public abstract Object computeResult();
}

class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        int left = (int) super.getRequest().getLeftOperand();
        int right = (int) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return null;
        }
    }
}

class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        double left = (double) super.getRequest().getLeftOperand();
        double right = (double) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return null;
        }
    }
}

class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        boolean left = (boolean) super.getRequest().getLeftOperand();
        boolean right = (boolean) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation) {
            case "&&":
                return left && right;
            case "||":
                return left || right;
            default:
                return null;
        }
    }
}

class CalculatorTest {
    public static void main(String[] args) {
        String[] input = {"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1"};
        List<CalculatorResult> results = SmarterCalculator.calculate(input);

        for (CalculatorResult result : results) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}
