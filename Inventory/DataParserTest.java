package Inventory;

import java.util.List;

public class DataParserTest {
    public static void main(String[] args) {
        // Sample input data
        FileInput fileInput = new FileInput("/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt", "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt");
        
        List<String> productLines = fileInput.readProductFile();

        FileInput fileInput2 = new FileInput("/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt", "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt");
        
        
        List<String> supplierLines = fileInput2.readSupplierFile();

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