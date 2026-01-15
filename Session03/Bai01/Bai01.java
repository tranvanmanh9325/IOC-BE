package Bai01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Bai01 {

    // Hàm tính tổng tiền
    public static double tong_tien (double gia_san_pham, int so_luong_mua, boolean the_thanh_vien) {
        double tong_tien_chua_VAT = gia_san_pham *  (double) so_luong_mua;
        if (the_thanh_vien) {
            return tong_tien_chua_VAT * (1 - 0.1) + tong_tien_chua_VAT * 0.08;
        }
        else  {
            return tong_tien_chua_VAT +  tong_tien_chua_VAT * 0.08;
        }
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("========= NHẬP THÔNG TIN HÓA ĐƠN =========");

        // Nhập tên khách hàng
        System.out.println("Nhập tên khách hàng: ");
        String ten_khach_hang = sc.nextLine();

        // Nhập tên sản phẩm
        System.out.println("Nhập tên sản phẩm: ");
        String san_pham = sc.nextLine();

        // Nhập giá sản phẩm
        System.out.println("Nhập giá sản phẩm: ");
        double gia_san_pham = sc.nextInt();

        // Nhập số lượng mua
        System.out.println("Nhập số lượng mua: ");
        int so_luong_mua = sc.nextInt();

        // Khách có thẻ thành viên?
        System.out.println("Khách có thẻ thành viên: ");
        boolean the_thanh_vien = sc.nextBoolean();

        // Hàm tính tổng tiền
        double tong_tien_thanh_toan = tong_tien(gia_san_pham, so_luong_mua, the_thanh_vien);

        // Format lại số trước khi hiển thị
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

        // In kết quả ra màn hình
        System.out.println("================ HÓA ĐƠN ================");
        System.out.println("Khách hàng: " + ten_khach_hang);
        System.out.println("Sản phẩm: " + san_pham);
        System.out.println("Số lượng: " + so_luong_mua);
        System.out.println("Đơn giá: " +  decimalFormat.format(gia_san_pham) + "VND");
        System.out.println("Thành tiền: " +  decimalFormat.format(gia_san_pham * (double) so_luong_mua) + "VND");
        System.out.println("Giảm giá thành viên: " +  decimalFormat.format(gia_san_pham * (double) so_luong_mua * 0.1));
        System.out.println("Tiền VAT (8%): " + decimalFormat.format(gia_san_pham * (double) so_luong_mua * 0.08) + "VND");
        System.out.println("Tổng thanh toán: " + decimalFormat.format(tong_tien_thanh_toan) + "VND");

        sc.close();
    }
}
