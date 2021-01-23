import java.util.*;

public class InsuranceCalculator {

    private InsuranceStrategy strategy;

    Map<Double, InsuranceStrategy> incomeBands = new LinkedHashMap<>() {{
        put(10_000.0, new InsuranceStrategyLow());
        put(30_000.0, new InsuranceStrategyMedium());
        put(60_000.0, new InsuranceStrategyHigh());
        put(Double.POSITIVE_INFINITY, new InsuranceStrategyVeryHigh());
    }};

    public double calculateInsurance(double income) {
        Optional<Double> mapIncomeToKey = incomeBands.keySet().stream().filter(num -> income <= num).findFirst();
        strategy = incomeBands.get(mapIncomeToKey.get());
        return strategy.calculate(income);
    }
}
