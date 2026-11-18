package salesreport;

/**
 * Contract for the product sales calculations (Q1.2).
 */
public interface IProduct {
    int GetTotalProductsSold();

    double GetAverageProductSold();

    String GetMostPopularProduct();
}
