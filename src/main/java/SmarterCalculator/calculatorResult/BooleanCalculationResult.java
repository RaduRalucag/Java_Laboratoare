package SmarterCalculator.calculatorResult;

import SmarterCalculator.CalculationRequest;
import SmarterCalculator.InvalidOperationException;

public class BooleanCalculationResult extends CalculationResult {
    public BooleanCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = null;
        try {
            request = getRequest();
            Boolean leftOperand = (Boolean) request.leftOperand();
            Boolean rightOperand = (Boolean) request.rightOperand();

            return switch (request.operation()) {
                case "&&" -> leftOperand && rightOperand;
                case "||" -> leftOperand || rightOperand;
                default -> throw new IllegalArgumentException();
            };

        } catch (IllegalArgumentException e) {
            assert request != null;
            throw new InvalidOperationException(request.operation());
        }


    }
}
