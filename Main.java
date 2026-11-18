package salesreport;

import java.util.Scanner;

/**
 * Q1.1 - Console application that captures three months of sales for each
 * mattress and prints a summary report.
 */
public class Main {

    private static final int MONTHS = 3;
    private static final int REPORT_YEAR = 2026;

    public static void main(String[] args) {
        // Single-dimensional array of product names
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array: one row per product, one column per month
        int[][] sales = new int[names.length][MONTHS];

        Scanner input = new Scanner(System.in);

        // Capture the sales figures
        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < MONTHS; m++) {
                sales[p][m] = ReadSales(input, m + 1, names[p]);
            }
            System.out.println();
        }

        // Calculate and print the report
        Product product = new Product(names, sales);
        PrintProduct printer = new PrintProduct(product);

        printer.PrintHeading(REPORT_YEAR);
        printer.PrintTotalSales();
        printer.PrintAverageSales();
        printer.PrintMostPopularProduct();

        input.close();
    }

    /**
     * Keeps asking until the user enters a whole number that is zero or more.
     */
    private static int ReadSales(Scanner input, int month, String productName) {
        while (true) {
            System.out.print("Enter number of sales for month " + month
                    + " for " + productName + " mattress: ");
            String text = input.nextLine().trim();
            try {
                int value = Integer.parseInt(text);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // fall through to the error message below
            }
            System.out.println("Please enter a whole number of 0 or more.");
        }
    }
}
