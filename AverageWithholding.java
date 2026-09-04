import java.util.Scanner;

public class AverageWithholding {

    public static void main(String[] args) {

        // Weekly average tax withholding percentage values 
        final double RATE_BELOW_500 = 0.10;
        final double RATE_500_TO_1499 = 0.15;
        final double RATE_1500_TO_2499 = 0.20;
        final double RATE_2500_AND_ABOVE = 0.30;

        Scanner input = new Scanner(System.in);
        double weeklyIncome;

        System.out.println("Weekly Tax Withholding Calculator");

        // Ask the user for income and validate the entry
        while (true) {
            System.out.print("Enter the customer's weekly income: $");

            if (input.hasNextDouble()) {
                weeklyIncome = input.nextDouble();

                if (weeklyIncome >= 0) {
                    break;
                }

                System.out.println(
                        "Income cannot be negative. Please try again.");
            } else {
                System.out.println(
                        "Invalid entry. Please enter a number.");

                // Remove the invalid entry from the Scanner
                input.next();
            }
        }

        double taxRate;

        // Selects the correct tax rate
        if (weeklyIncome < 500) {
            taxRate = RATE_BELOW_500;
        } else if (weeklyIncome < 1500) {
            taxRate = RATE_500_TO_1499;
        } else if (weeklyIncome < 2500) {
            taxRate = RATE_1500_TO_2499;
        } else {
            taxRate = RATE_2500_AND_ABOVE;
        }

        // Calculate the withholding and take-home pay
        double taxWithholding = weeklyIncome * taxRate;
        double takeHomePay = weeklyIncome - taxWithholding;

        // Display the results
        System.out.println("\nWeekly Withholding Results");
        System.out.println("--------------------------");
        System.out.printf(
                "Weekly income:       $%,.2f%n", weeklyIncome);
        System.out.printf(
                "Tax rate:             %.0f%%%n", taxRate * 100);
        System.out.printf(
                "Tax withholding:     $%,.2f%n", taxWithholding);
        System.out.printf(
                "Take-home pay:       $%,.2f%n", takeHomePay);

        input.close();
    }
}