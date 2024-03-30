package Inventory;

import java.util.List;

public class NewMain {

    private FileInput fileInput;
    private DataParser dataParser;
    private DataFormatter dataFormatter;
    private OutputFileGenerator outputFileGenerator;
    private List<String> productLines;
    private List<String> supplierLines;
    private String productFilePath;
    private String supplierFilePath;

    public NewMain() {
        setUp();
    }

    private void setUp() {

        productFilePath = "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt";
        supplierFilePath = "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt";
        fileInput = new FileInput(productFilePath, supplierFilePath);
        dataParser = new DataParser();
        dataFormatter = new DataFormatter();
        outputFileGenerator = new OutputFileGenerator();

        // Initialize sample product and supplier lines
        productLines = fileInput.readProductFile();

        supplierLines = fileInput.readSupplierFile();
    }

    public void testOutputFileGeneration_Successful() {
        // Parse the input files
        List<Product> products = dataParser.parseProducts(productLines);
        List<Supplier> suppliers = dataParser.parseSuppliers(supplierLines);

        // Format the data
        String formattedData = dataFormatter.formatInventoryData(products, suppliers);

        // Generate the output file
        boolean fileGenerated = outputFileGenerator.writeToFile(formattedData, "InventoryFile.txt");

        // Verify that the file was generated successfully
        if (fileGenerated) {
            System.out.println("Test: testOutputFileGeneration_Successful - PASSED");
        } else {
            System.out.println("Test: testOutputFileGeneration_Successful - FAILED");
        }
    }

    // public void testOutputFileGeneration_ErrorInDataFormatting() {
    //     // In this test case, intentionally pass null as formatted data to simulate an error in data formatting

    //     // Generate the output file
    //     boolean fileGenerated = outputFileGenerator.writeToFile(null, "InventoryFile.txt");

    //     // Verify that the file was not generated due to errors in data formatting
    //     if (!fileGenerated) {
    //         System.out.println("Test: testOutputFileGeneration_ErrorInDataFormatting - PASSED");
    //     } else {
    //         System.out.println("Test: testOutputFileGeneration_ErrorInDataFormatting - FAILED");
    //     }
    // }

    public static void main(String[] args) {
        NewMain test = new NewMain();
        test.testOutputFileGeneration_Successful();
        // test.testOutputFileGeneration_ErrorInDataFormatting();
    }
}