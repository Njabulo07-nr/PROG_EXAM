package salesreport;

/**
 * Holds the sales figures for each product and does the report calculations.
 */
public class Product implements IProduct {

    // 1D array: the name of each product
    private String[] productNames;

    // 2D array: sales[product][month]
    private int[][] sales;

    // 1D array: the total sold for each product (over all months)
    private int[] productTotals;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;

        // Work out the total for each product once, when the object is created
        productTotals = new int[sales.length];
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                productTotals[p] = productTotals[p] + sales[p][m];
            }
        }
    }

    // Adds up the totals of all the products
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < productTotals.length; p++) {
            total = total + productTotals[p];
        }
        return total;
    }

    // Average = total sold divided by the number of entries (products x months)
    @Override
    public double GetAverageProductSold() {
        int entries = sales.length * sales[0].length;
        return (double) GetTotalProductsSold() / entries;
    }

    // The most popular product is the one with the highest total
    @Override
    public String GetMostPopularProduct() {
        return productNames[GetMostPopularIndex()];
    }

    // Total sold for the most popular product
    public int GetMostPopularTotal() {
        return productTotals[GetMostPopularIndex()];
    }

    // Finds the position of the highest total in the array
    private int GetMostPopularIndex() {
        int best = 0;
        for (int p = 1; p < productTotals.length; p++) {
            if (productTotals[p] > productTotals[best]) {
                best = p;
            }
        }
        return best;
    }
}
