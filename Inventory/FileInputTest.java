package Inventory;

import java.io.IOException;
import java.util.List;

public class FileInputTest {

    public static void main(String[] args) {
        testReadProductFile();
        testReadSupplierFile();
    }

    public static void testReadProductFile() {
        FileInput fileInput = new FileInput("/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt", "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt");
        
        try {
            List<String> productLines = fileInput.readProductFile();
            System.out.println("Product lines:");
            for (String line : productLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading product file: " + e.getMessage());
        }
    }

    public static void testReadSupplierFile() {
        FileInput fileInput = new FileInput("/Users/anmol/Desktop/CP317/cp317 project code/Inventory/ProductFile.txt", "/Users/anmol/Desktop/CP317/cp317 project code/Inventory/SupplierFile.txt");
        
        try {
            List<String> supplierLines = fileInput.readSupplierFile();
            System.out.println("Supplier lines:");
            for (String line : supplierLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading supplier file: " + e.getMessage());
        }
    }
}
