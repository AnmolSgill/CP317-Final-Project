package Inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataFormatter {
    public void formatInventoryFile(List<Product> products, List<Supplier> suppliers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("InventoryFile.txt"))) {
            // Write the header
            writer.write("Product ID, Product Name, Quantity, Price, Status, Supplier Name");
            writer.newLine();

            // Write products
            for (Product product : products) {
                try {
                    writer.write(formatProduct(product, suppliers));
                    writer.newLine();
                } catch (SupplierNotFoundException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

            System.out.println("Inventory data formatted and written to InventoryFile.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to InventoryFile.txt: " + e.getMessage());
        }
    }

    private String formatProduct(Product product, List<Supplier> suppliers) throws SupplierNotFoundException  {
        String supplierName = findSupplierName(product.getSupplierID(), suppliers);
        if (supplierName == null) {
            // Handle case where supplier name is not found for the given supplier ID
            supplierName = "Unknown";
        }
        return String.format("%s, %s, %d, %s, %s, %s",
            product.getProductId(),
            product.getProductName(),
            product.getQuantity(),
            product.getPrice(),
            product.getStatus(),
            supplierName);
    }

    private String findSupplierName(int supplierId, List<Supplier> suppliers) throws SupplierNotFoundException {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierID() == supplierId){
                return supplier.getSupplierName();
            }
        }
        throw new SupplierNotFoundException("Supplier not found for the given supplier ID: " + supplierId);
    }
}
