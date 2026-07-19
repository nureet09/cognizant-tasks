package DataStructures.FinancialForecasting;

public class ForecastingTest {
    public static void main(String[] args) {
        double presentValue = 1000.0; // Starting capital
        double growthRate = 0.05;     // 5% annual growth rate
        int targetYears = 5;          // Predict 5 years into the future

        System.out.println("--- Testing Financial Forecasting via Recursion ---");
        System.out.println("Initial Present Value: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecasting Period: " + targetYears + " years\n");

        // Calculate using recursive approach
        double futureValueRec = FinancialPredictor.calculateFutureValueRecursive(presentValue, growthRate, targetYears);
        System.out.printf("Predicted Future Value (Recursive): $%.2f\n", futureValueRec);

        // Calculate using optimized approach
        double futureValueOpt = FinancialPredictor.calculateFutureValueOptimized(presentValue, growthRate, targetYears);
        System.out.printf("Predicted Future Value (Optimized Memoization): $%.2f\n", futureValueOpt);
    }
}