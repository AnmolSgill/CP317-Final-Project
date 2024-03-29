package Inventory;

import java.util.List;

public class DataParserTest {
    public static void main(String[] args) {
        // Sample input data
        List<String> productLines = List.of(
            "2591, Camera, Camera, $799.9, 40, A, 7890",
            "3374, Laptop, MacBook Pro, $1799.9, 30, A, 9876",
            "3034, Telephone, Cordless Phone, $299.99, 40, A, 3456"
            // Add more sample product lines as needed
        );

        List<String> supplierLines = List.of(
            "9512, Acme Corporation, 123 Main St, 205-288-8591, info@acme-corp.com",
            "8642, Xerox Inc., 456 High St, 505-398-8414, info@xrx.com",
            "3579, RedPark Ltd., 789 Park Ave, 604-683-2555, info@redpark.ca"
            // Add more sample supplier lines as needed
        );

        // Create DataParser instance
        DataParser dataParser = new DataParser();

        // Parse products
        try {
            List<Product> products = dataParser.parseProducts(productLines);
            System.out.println("Parsed Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing products: " + e.getMessage());
        }

        // Parse suppliers
        try {
            List<Supplier> suppliers = dataParser.parseSuppliers(supplierLines);
            System.out.println("\nParsed Suppliers:");
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing suppliers: " + e.getMessage());
        }
    }
}