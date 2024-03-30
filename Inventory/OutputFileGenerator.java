package Inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileGenerator {
    public void writeToFile(String data, String fileName) {
        if (data != null) { // Check if data is not null (indicating no errors in formatting)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(data);
                System.out.println("InventoryFile.txt has been successfully created.");
            } catch (IOException e) {
                System.err.println("Error writing to InventoryFile.txt: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to create InventoryFile.txt due to errors in data formatting.");
        }
    }
}