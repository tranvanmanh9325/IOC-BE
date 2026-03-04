package Session18;

import java.sql.Date;

public class Product {
    private int productId;
    private String productName;
    private float productPrice;
    private String productTitle;
    private Date productCreated;
    private String productCatalog;
    private boolean productStatus;

    // Constructors
    public Product() {}

    public Product(int productId, String productName, float productPrice, String productTitle, Date productCreated, String productCatalog, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
        this.productCreated = productCreated;
        this.productCatalog = productCatalog;
        this.productStatus = productStatus;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getProductPrice() { return productPrice; }
    public void setProductPrice(float productPrice) { this.productPrice = productPrice; }
    public String getProductTitle() { return productTitle; }
    public void setProductTitle(String productTitle) { this.productTitle = productTitle; }
    public Date getProductCreated() { return productCreated; }
    public void setProductCreated(Date productCreated) { this.productCreated = productCreated; }
    public String getProductCatalog() { return productCatalog; }
    public void setProductCatalog(String productCatalog) { this.productCatalog = productCatalog; }
    public boolean isProductStatus() { return productStatus; }
    public void setProductStatus(boolean productStatus) { this.productStatus = productStatus; }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Tên: %-20s | Giá: %-10.2f | Tiêu đề: %-20s | Danh mục: %-15s | Ngày: %-10s | Trạng thái: %s",
                productId, productName, productPrice, productTitle, productCatalog, productCreated.toString(), (productStatus ? "Hoạt động" : "Không hoạt động"));
    }
}