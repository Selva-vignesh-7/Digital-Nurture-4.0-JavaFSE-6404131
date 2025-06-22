import java.util.Scanner;

public class FinancialForecast {

    /**
     * Recursively calculates future value.
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static double futureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return futureValueRecursive(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    /**
     * Iterative version to avoid recursion stack.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static double futureValueIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    /**
     * Direct formula (most efficient).
     * Time Complexity: O(1), Space Complexity: O(1)
     */
    public static double futureValueFormula(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        double recursiveResult = futureValueRecursive(currentValue, growthRate, years);
        double iterativeResult = futureValueIterative(currentValue, growthRate, years);
        double formulaResult = futureValueFormula(currentValue, growthRate, years);

        System.out.printf("Recursive Future Value: %.2f\n", recursiveResult);
        System.out.printf("Iterative Future Value: %.2f\n", iterativeResult);
        System.out.printf("Formula Future Value: %.2f\n", formulaResult);

        scanner.close();
    }
}