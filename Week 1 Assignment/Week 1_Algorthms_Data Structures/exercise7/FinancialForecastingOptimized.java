package exercise7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialForecastingOptimized {
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double predictFutureValue(double currentValue, double growthRate, int periods) {
        
        if (periods == 0) {
            return currentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double futureValue = predictFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (in decimal form, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of periods (years): ");
        int periods = scanner.nextInt();

        double futureValue = predictFutureValue(currentValue, growthRate, periods);

        System.out.printf("The predicted future value after %d years is: %.2f%n", periods, futureValue);

        scanner.close();
    }
}

