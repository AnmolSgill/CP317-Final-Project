package Inventory;

import java.util.List;

public class InventoryApplicationMain{
    
    public static void main(String[] args) {
        // if (args.length != 2) {
        //     System.err.println("Usage: java InventoryApplicationMain <ProductFile File path> <SupplierFile File path>");
        //     return;
        // }

        String productFilePath = "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt";
        String supplierFilePath = "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt";

        // Initialize classes
        FileInput fileInput = new FileInput(productFilePath, supplierFilePath);
        DataParser dataParser = new DataParser();
        DataFormatter dataFormatter = new DataFormatter();
        OutputFileGenerator outputFileGenerator = new OutputFileGenerator();

        // Read input files
        List<String> productLines = fileInput.readProductFile();
        List<String> supplierLines = fileInput.readSupplierFile();

        // Parse data
        List<Product> products = dataParser.parseProducts(productLines);
        List<Supplier> suppliers = dataParser.parseSuppliers(supplierLines);

        // Format data
        String formattedData = dataFormatter.formatInventoryData(products, suppliers);

        // Write to file
        boolean fileGenerated = outputFileGenerator.writeToFile(formattedData, "InventoryFile.txt");

        // Print status
        if (fileGenerated) {
            System.out.println("InventoryFile.txt has been successfully created.");
        } else {
            System.err.println("Failed to create InventoryFile.txt.");
        }
    }

}
