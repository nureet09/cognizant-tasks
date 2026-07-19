package DataStructures.FinancialForecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialPredictor {

    // 1. Standard Recursive Approach (As requested in Step 2 & 3)
    // Computes: Future Value = Present Value * (1 + growthRate)^years
    // Recursion logic: forecastRecursive(pv, r, t) = forecastRecursive(pv, r, t-1) * (1 + r)
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int years) {
        // Base Case: 0 years means value remains the same
        if (years <= 0) {
            return currentValue;
        }
        // Recursive Case: Value next year is this year's value compounded
        return calculateFutureValueRecursive(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // 2. Optimized Approach using Memoization (Step 4 Optimization)
    // Prevents recalculating subproblems if calculating complex linear multi-variable dependencies
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int years) {
        if (years <= 0) {
            return currentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = calculateFutureValueOptimized(currentValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }
}