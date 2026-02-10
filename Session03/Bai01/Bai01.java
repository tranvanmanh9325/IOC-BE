package Bai01;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Bai01 {
    // Hàm tính tổng tiền thanh toán
    public static long tongTien (long thanhTien, long giamThanhVien) {
        return (thanhTien - giamThanhVien + thanhTien * 8 / 100);
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // Nhập thông tin
        System.out.println("==================== Nhập thông tin ======================");

        System.out.print("Nhập tên khách hàng: ");
        String khachHang =  scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String sanPham = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        long gia =  scanner.nextLong();

        System.out.print("Nhập số lượng mua: ");
        int soLuong = scanner.nextInt();

        System.out.print("Khách hàng có thẻ thành viên hay không: ");
        boolean theThanhVien = scanner.nextBoolean();

        // Xử lý
        long thanhTien = gia * (long)soLuong;
        long giamThanhVien;
        if (theThanhVien) {
            giamThanhVien = thanhTien * 10 / 100;
        } else {
            giamThanhVien = 0;
        }
        long tongTien = tongTien(thanhTien, giamThanhVien);

        // Format lại số trước khi hiển thị
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        // In thông tin
        System.out.println("==================== Hóa đơn ======================");

        System.out.println("Khách hàng: " + khachHang);
        System.out.println("Sản phẩm: " + sanPham);
        System.out.println("Giá: " + decimalFormat.format(gia) + " VNĐ");
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + decimalFormat.format(thanhTien));
        System.out.println("Giảm giá: " +  decimalFormat.format(giamThanhVien));
        System.out.println("Tiền VAT: " +  decimalFormat.format(thanhTien * 8L / 100));
        System.out.println("Tổng tiền thanh toán: " +  decimalFormat.format(tongTien) + " VNĐ");

        scanner.close();
    }
}
