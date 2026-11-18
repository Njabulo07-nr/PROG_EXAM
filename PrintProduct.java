package salesreport;

/**
 * Only responsible for printing the report data.
 */
public class PrintProduct {

    private Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void PrintHeading(int year) {
        System.out.println("PRODUCT SALES REPORT - " + year);
        System.out.println("*********************************************");
    }

    public void PrintTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageSales() {
        double average = product.GetAverageProductSold();

        // Show 17 instead of 17.0 when the average is a whole number
        if (average == (int) average) {
            System.out.println("AVERAGE PRODUCT SALES: " + (int) average);
        } else {
            System.out.println("AVERAGE PRODUCT SALES: " + average);
        }
    }

    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()
                + " (" + product.GetMostPopularTotal() + ")");
    }
}
