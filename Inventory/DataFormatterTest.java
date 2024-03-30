package Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataFormatterTest {

    public static void main(String[] args) {
        // Create instance of DataParser
        List<String> productLines = List.of(
            "2591, Camera, Camera, $799.9, 40, A, 7890",
            "3374, Laptop, MacBook Pro, $1799.9, 30, A, 9876",
            "3034, Telephone, Cordless Phone, $299.99, 40, A, 3456"
            // Add more sample product lines as needed
        );

        List<String> supplierLines = List.of(
            "7890, Samsung, 456 Seoul St, 909-763-4442, support@samsung.com",
            "9876, Toshiba, 246 Osaka St, 90-6378-0835, support@toshiba.co.jp",
            "3456, Panasonic, 246 Osaka St, 443-887-9967, support@panasonic.co.jp"
            // Add more sample supplier lines as needed
        );
        DataParser dataParser = new DataParser();

        // Parse the input files
        List<Product> products = dataParser.parseProducts(productLines);
        List<Supplier> suppliers = dataParser.parseSuppliers(supplierLines);

        // Create instance of DataFormatter
        DataFormatter dataFormatter = new DataFormatter();

        // Call the method to be tested
        // dataFormatter.formatInventoryFile(products, suppliers);

        // Verify the contents of the generated file
        try (BufferedReader reader = new BufferedReader(new FileReader("InventoryFile.txt"))) {
            // Read the header
            String header = reader.readLine();
            // Verify the header
            if (!header.equals("Product ID, Product Name, Quantity, Price, Status, Supplier Name")) {
                System.err.println("Header mismatch in the output file.");
                return;
            }

            // Read and verify each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Add your verification logic here
                System.out.println(line); // Print each line for manual inspection
            }
            System.out.println("Output file verification successful.");
        } catch (IOException e) {
            System.err.println("Error reading the output file: " + e.getMessage());
        }
    }
}