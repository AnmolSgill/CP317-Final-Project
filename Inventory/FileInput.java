package Inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {
    private String productFilePath;
    private String supplierFilePath;

    public FileInput(String productFilePath, String supplierFilePath) {
        this.productFilePath = productFilePath;
        this.supplierFilePath = supplierFilePath;
    }

    public List<String> readProductFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(productFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e) {
            System.err.println("Error reading the Product file: " + e.getMessage());
        }

        return lines;
    }

    public List<String> readSupplierFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(supplierFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e) {
            System.err.println("Error reading the Supplier file: " + e.getMessage());
        }
    
        return lines;
    }
}