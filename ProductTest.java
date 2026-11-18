package salesreport.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import salesreport.Product;

/**
 * Q1.4 - Unit tests for the Product class.
 */
public class ProductTest {

    // Sample data from the question paper
    private Product CreateProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        return new Product(names, sales);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, CreateProduct().GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, CreateProduct().GetAverageProductSold(), 0.001);
    }
}
