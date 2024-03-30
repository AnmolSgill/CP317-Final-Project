package Inventory;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class DataFormatter {
    public String formatInventoryData(List<Product> products, List<Supplier> suppliers) {

        Collections.sort(products, Comparator.comparingInt(Product::getProductId));
        StringBuilder formattedData = new StringBuilder();
        formattedData.append("Product ID, Product Name, Quantity, Price, Status, Supplier Name\n");

        for (Product product : products) {
            try {
                String formattedProduct = formatProduct(product, suppliers);
                if (formattedProduct != null) {
                    formattedData.append(formattedProduct).append("\n");
                }
            } catch (SupplierNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        return formattedData.toString();
    }

    private String formatProduct(Product product, List<Supplier> suppliers) throws SupplierNotFoundException {
        String supplierName = findSupplierName(product.getSupplierID(), suppliers);
        return String.format("%d, %s, %d, %s, %s, %s",
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
