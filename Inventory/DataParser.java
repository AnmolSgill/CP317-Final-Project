package Inventory;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<Product> parseProducts(List<String> productLines) throws IllegalArgumentException {
        List<Product> products = new ArrayList<>();
        for (String line : productLines) {
            String[] fields = line.split(",");
            if (fields.length != 7) {
                throw new IllegalArgumentException("Invalid number of fields in product line: " + line);
            }
            for (String field : fields) {
                if (field.trim().isEmpty()) {
                    throw new IllegalArgumentException("Empty field found in product line: " + line);
                }
            }
            try {
                int productId = Integer.parseInt(fields[0].trim());
                if (productId < 0) {
                    throw new IllegalArgumentException("Negative product ID found in product line: " + line);
                }
                String productName = fields[1].trim();
                String description = fields[2].trim();
                double price = Double.parseDouble(fields[3].trim().replace("$", ""));
                if (price < 0) {
                    throw new IllegalArgumentException("Negative price found in product line: " + line);
                }
                int quantity = Integer.parseInt(fields[4].trim());
                if (quantity < 0) {
                    throw new IllegalArgumentException("Negative quantity found in product line: " + line);
                }
                char status = fields[5].trim().charAt(0); // Assuming status is a single character
                if (!Character.isLetter(status)) {
                    throw new IllegalArgumentException("Invalid status value found in product line: " + line);
                }
                int supplierId = Integer.parseInt(fields[6].trim());
                if (supplierId < 0) {
                    throw new IllegalArgumentException("Negative supplier ID found in product line: " + line);
                }

                Product product = new Product(productId, productName, description, price, quantity, status, supplierId);
                products.add(product);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid data type in product line: " + line);
            }
        }
        return products;
    }

    public List<Supplier> parseSuppliers(List<String> supplierLines) throws IllegalArgumentException {
        List<Supplier> suppliers = new ArrayList<>();
        for (String line : supplierLines) {
            String[] fields = line.split(",");
            if (fields.length != 5) {
                throw new IllegalArgumentException("Invalid number of fields in supplier line: " + line);
            }
            for (String field : fields) {
                if (field.trim().isEmpty()) {
                    throw new IllegalArgumentException("Empty field found in supplier line: " + line);
                }
            }
            try {
                int supplierId = Integer.parseInt(fields[0].trim());
                if (supplierId < 0) {
                    throw new IllegalArgumentException("Negative supplier ID found in supplier line: " + line);
                }
                String supplierName = fields[1].trim();
                String address = fields[2].trim();
                String phone = fields[3].trim();
                String email = fields[4].trim();

                Supplier supplier = new Supplier(supplierId, supplierName, address, phone, email);
                suppliers.add(supplier);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid data type in supplier line: " + line);
            }
        }
        return suppliers;
    }
}
