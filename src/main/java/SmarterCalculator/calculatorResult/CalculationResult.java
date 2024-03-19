package SmarterCalculator.calculatorResult;

import SmarterCalculator.CalculationRequest;
import lombok.Getter;

@Getter
public abstract class CalculationResult {
    private final CalculationRequest request;

    public CalculationResult(CalculationRequest request) {
        this.request = request;
    }

    public abstract Object computeResult();
}
