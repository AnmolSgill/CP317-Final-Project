package Inventory;

public class Product {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private char status;
    private int supplierId;

    public Product(int productId, String productName, String description, double price, int quantity, char status, int supplierId) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.supplierId = supplierId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
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

    public int getSupplierID() {
        return supplierId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status=" + status +
                ", supplierId=" + supplierId +
                '}';
    }
    
}