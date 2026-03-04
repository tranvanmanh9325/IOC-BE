-- 1. Tạo Database (Chạy lệnh này trước, sau đó kết nối vào database vừa tạo để chạy các lệnh dưới)
-- CREATE DATABASE ProductManagement;

-- 2. Tạo bảng Product
CREATE TABLE Product (
    Product_Id SERIAL PRIMARY KEY, -- SERIAL tự động tăng (auto_increment)
    Product_Name VARCHAR(100) NOT NULL UNIQUE,
    Product_Price FLOAT NOT NULL CHECK (Product_Price > 0),
    Product_Title VARCHAR(200) NOT NULL,
    Product_created DATE NOT NULL,
    Product_catalog VARCHAR(100) NOT NULL,
    Product_Status BOOLEAN DEFAULT TRUE -- Dùng Boolean thay cho Bit trong Postgres, True = 1
);

-- 3. Các Stored Procedure / Function

-- Lấy tất cả thông tin sản phẩm
CREATE OR REPLACE FUNCTION get_all_products()
RETURNS TABLE(id INT, name VARCHAR, price FLOAT, title VARCHAR, created DATE, catalog VARCHAR, status BOOLEAN) AS $$
BEGIN
    RETURN QUERY SELECT * FROM Product;
END;
$$ LANGUAGE plpgsql;

-- Thêm mới một sản phẩm
CREATE OR REPLACE PROCEDURE insert_product(
    p_name VARCHAR, p_price FLOAT, p_title VARCHAR, p_created DATE, p_catalog VARCHAR, p_status BOOLEAN
) AS $$
BEGIN
    INSERT INTO Product(Product_Name, Product_Price, Product_Title, Product_created, Product_catalog, Product_Status)
    VALUES(p_name, p_price, p_title, p_created, p_catalog, p_status);
END;
$$ LANGUAGE plpgsql;

-- Cập nhật sản phẩm theo mã
CREATE OR REPLACE PROCEDURE update_product(
    p_id INT, p_name VARCHAR, p_price FLOAT, p_title VARCHAR, p_created DATE, p_catalog VARCHAR, p_status BOOLEAN
) AS $$
BEGIN
    UPDATE Product
    SET Product_Name = p_name, Product_Price = p_price, Product_Title = p_title, 
        Product_created = p_created, Product_catalog = p_catalog, Product_Status = p_status
    WHERE Product_Id = p_id;
END;
$$ LANGUAGE plpgsql;

-- Xóa một sản phẩm theo mã
CREATE OR REPLACE PROCEDURE delete_product(p_id INT) AS $$
BEGIN
    DELETE FROM Product WHERE Product_Id = p_id;
END;
$$ LANGUAGE plpgsql;

-- Lấy thông tin sản phẩm theo mã
CREATE OR REPLACE FUNCTION get_product_by_id(p_id INT)
RETURNS TABLE(id INT, name VARCHAR, price FLOAT, title VARCHAR, created DATE, catalog VARCHAR, status BOOLEAN) AS $$
BEGIN
    RETURN QUERY SELECT * FROM Product WHERE Product_Id = p_id;
END;
$$ LANGUAGE plpgsql;

-- Tìm kiếm sản phẩm theo tên (tương đối)
CREATE OR REPLACE FUNCTION search_product_by_name(p_name VARCHAR)
RETURNS TABLE(id INT, name VARCHAR, price FLOAT, title VARCHAR, created DATE, catalog VARCHAR, status BOOLEAN) AS $$
BEGIN
    RETURN QUERY SELECT * FROM Product WHERE Product_Name ILIKE '%' || p_name || '%';
END;
$$ LANGUAGE plpgsql;

-- Sắp xếp sản phẩm theo giá tăng dần (Hỗ trợ cho Menu 6)
CREATE OR REPLACE FUNCTION sort_products_by_price()
RETURNS TABLE(id INT, name VARCHAR, price FLOAT, title VARCHAR, created DATE, catalog VARCHAR, status BOOLEAN) AS $$
BEGIN
    RETURN QUERY SELECT * FROM Product ORDER BY Product_Price ASC;
END;
$$ LANGUAGE plpgsql;

-- Thống kê số lượng sản phẩm theo danh mục
CREATE OR REPLACE FUNCTION count_products_by_catalog()
RETURNS TABLE(catalog VARCHAR, total_count BIGINT) AS $$
BEGIN
    RETURN QUERY SELECT Product_catalog, COUNT(*) FROM Product GROUP BY Product_catalog;
END;
$$ LANGUAGE plpgsql;