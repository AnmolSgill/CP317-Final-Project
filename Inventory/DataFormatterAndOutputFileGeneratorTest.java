package Inventory;

import java.util.List;

public class DataFormatterAndOutputFileGeneratorTest {

    private DataParser dataParser;
    private DataFormatter dataFormatter;
    private OutputFileGenerator outputFileGenerator;
    private List<String> productLines;
    private List<String> supplierLines;

    public DataFormatterAndOutputFileGeneratorTest() {
        setUp();
    }

    private void setUp() {
        dataParser = new DataParser();
        dataFormatter = new DataFormatter();
        outputFileGenerator = new OutputFileGenerator();

        // Initialize sample product and supplier lines
        productLines = List.of(
            "2591, Camera, Camera, $799.9, 40, A, 7890",
            "3374, Laptop, MacBook Pro, $1799.9, 30, A, 9876",
            "3034, Telephone, Cordless Phone, $299.99, 40, A, 3456"
            // Add more sample product lines as needed
        );

        supplierLines = List.of(
            "7890, Samsung, 456 Seoul St, 909-763-4442, support@samsung.com",
            "9876, Toshiba, 246 Osaka St, 90-6378-0835, support@toshiba.co.jp",
            "3456, Panasonic, 246 Osaka St, 443-887-9967, support@panasonic.co.jp"
            // Add more sample supplier lines as needed
        );
    }

    public void testOutputFileGeneration_Successful() {
        // Parse the input files
        List<Product> products = dataParser.parseProducts(productLines);
        List<Supplier> suppliers = dataParser.parseSuppliers(supplierLines);

        // Format the data
        String formattedData = dataFormatter.formatInventoryData(products, suppliers);

        // Generate the output file
        boolean fileGenerated = outputFileGenerator.writeToFile(formattedData, "InventoryFIle.txt");

        // Verify that the file was generated successfully
        if (fileGenerated) {
            System.out.println("Test: testOutputFileGeneration_Successful - PASSED");
        } else {
            System.out.println("Test: testOutputFileGeneration_Successful - FAILED");
        }
    }

    public void testOutputFileGeneration_ErrorInDataFormatting() {
        // In this test case, intentionally pass null as formatted data to simulate an error in data formatting

        // Generate the output file
        boolean fileGenerated = outputFileGenerator.writeToFile(null, "InventoryFile.txt");

        // Verify that the file was not generated due to errors in data formatting
        if (!fileGenerated) {
            System.out.println("Test: testOutputFileGeneration_ErrorInDataFormatting - PASSED");
        } else {
            System.out.println("Test: testOutputFileGeneration_ErrorInDataFormatting - FAILED");
        }
    }

    public static void main(String[] args) {
        DataFormatterAndOutputFileGeneratorTest test = new DataFormatterAndOutputFileGeneratorTest();
        test.testOutputFileGeneration_Successful();
        test.testOutputFileGeneration_ErrorInDataFormatting();
    }
}