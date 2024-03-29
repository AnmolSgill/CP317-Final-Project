package Inventory;

public class InventoryEntry {
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private char status;
    private String supplierName;

    public InventoryEntry(int productId, String productName, int quantity, double price, char status, String supplierName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.supplierName = supplierName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public char getStatus() {
        return status;
    }

    public String getSupplierName() {
        return supplierName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status=" + status +
                ", supplierName=" + supplierName + '\'' +
                '}';
    }
}