package Session18;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n******************** PRODUCT MANAGEMENT ********************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("8. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: displayProducts("{call get_all_products()}"); break;
                case 2: addProduct(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: searchProduct(); break;
                case 6: displayProducts("{call sort_products_by_price()}"); break;
                case 7: countByCategory(); break;
                case 8: System.out.println("Thoát chương trình!"); break;
                default: System.out.println("Vui lòng chọn từ 1 đến 8.");
            }
        } while (choice != 8);
    }

    // Yêu cầu: Hiển thị danh sách sản phẩm
    private static void displayProducts(String query) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"), rs.getString("name"), rs.getFloat("price"),
                        rs.getString("title"), rs.getDate("created"), rs.getString("catalog"), rs.getBoolean("status")
                );
                System.out.println(p.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Yêu cầu: Thêm sản phẩm + Validate + Transaction
    private static void addProduct() {
        Product p = inputProductData(false); // false vì là thêm mới, không cần nhập ID
        
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false); // BẮT ĐẦU TRANSACTION

            CallableStatement cs = conn.prepareCall("{call insert_product(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, p.getProductName());
            cs.setFloat(2, p.getProductPrice());
            cs.setString(3, p.getProductTitle());
            cs.setDate(4, p.getProductCreated());
            cs.setString(5, p.getProductCatalog());
            cs.setBoolean(6, p.isProductStatus());
            
            cs.executeUpdate();
            
            conn.commit(); // XÁC NHẬN TRANSACTION
            System.out.println("Thêm sản phẩm thành công!");
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); } // ROLLBACK NẾU LỖI
            System.out.println("Lỗi khi thêm sản phẩm (Có thể trùng tên): " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // Yêu cầu: Cập nhật sản phẩm + Transaction
    private static void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Product p = inputProductData(true);
        p.setProductId(id);

        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false); // BẮT ĐẦU TRANSACTION

            CallableStatement cs = conn.prepareCall("{call update_product(?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, p.getProductId());
            cs.setString(2, p.getProductName());
            cs.setFloat(3, p.getProductPrice());
            cs.setString(4, p.getProductTitle());
            cs.setDate(5, p.getProductCreated());
            cs.setString(6, p.getProductCatalog());
            cs.setBoolean(7, p.isProductStatus());
            
            int rowsAffected = cs.executeUpdate();
            
            conn.commit(); // XÁC NHẬN TRANSACTION
            if(rowsAffected > 0) System.out.println("Cập nhật thành công!");
            else System.out.println("Không tìm thấy sản phẩm có ID này.");
            
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // Yêu cầu: Xóa sản phẩm + Transaction
    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);

            CallableStatement cs = conn.prepareCall("{call delete_product(?)}");
            cs.setInt(1, id);
            int rowsAffected = cs.executeUpdate();
            
            conn.commit();
            if(rowsAffected > 0) System.out.println("Xóa thành công!");
            else System.out.println("Không tìm thấy sản phẩm cần xóa.");
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // Yêu cầu: Tìm kiếm theo tên (tương đối)
    private static void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall("{call search_product_by_name(?)}")) {
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getString("title"), rs.getDate("created"), rs.getString("catalog"), rs.getBoolean("status"));
                System.out.println(p.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Yêu cầu: Thống kê số lượng
    private static void countByCategory() {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall("{call count_products_by_catalog()}");
             ResultSet rs = cs.executeQuery()) {
            
            System.out.println("\n--- THỐNG KÊ THEO DANH MỤC ---");
            while (rs.next()) {
                System.out.println("Danh mục: " + rs.getString("catalog") + " - Số lượng: " + rs.getInt("total_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm phụ trợ: Nhập dữ liệu và Validate theo điều kiện ràng buộc (Constraints)
    private static Product inputProductData(boolean isUpdate) {
        Product p = new Product();
        
        // Bắt lỗi rỗng
        do {
            System.out.print("Nhập tên sản phẩm (Không được rỗng): ");
            p.setProductName(scanner.nextLine().trim());
        } while (p.getProductName().isEmpty());

        // Bắt lỗi giá > 0
        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm (> 0): ");
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    p.setProductPrice(price);
                    break;
                } else {
                    System.out.println("Lỗi: Giá phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
            }
        }

        do {
            System.out.print("Nhập tiêu đề sản phẩm: ");
            p.setProductTitle(scanner.nextLine().trim());
        } while (p.getProductTitle().isEmpty());

        // Validate ngày tháng
        while (true) {
            System.out.print("Nhập ngày tạo (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            try {
                java.util.Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                p.setProductCreated(new java.sql.Date(parsedDate.getTime()));
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không đúng (yyyy-MM-dd).");
            }
        }

        do {
            System.out.print("Nhập danh mục sản phẩm: ");
            p.setProductCatalog(scanner.nextLine().trim());
        } while (p.getProductCatalog().isEmpty());

        System.out.print("Trạng thái (1: Hoạt động, 0: Không hoạt động) [Mặc định 1]: ");
        String status = scanner.nextLine();
        p.setProductStatus(!status.equals("0")); // Trừ khi nhập 0, còn lại mặc định là true

        return p;
    }
}