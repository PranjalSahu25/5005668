package FinancialForecasting;
import java.util.Scanner;
public class FinancialForecasting {

    public static double calculateFutureValue(double principal, double growthRate, int years) {
        if (years == 0) {
            return principal;
        }
        return (1 + growthRate) * calculateFutureValue(principal, growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter the annual growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();
        
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        
        double futureValue = calculateFutureValue(principal, growthRate, years);
        System.out.println("The future value after " + years + " years is: " + futureValue);
        
        scanner.close();
    }
}
