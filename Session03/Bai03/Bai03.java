package Bai03;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai03 {
    // Khai báo mảng ArrayList danh sách lương
    static ArrayList<Long> danhSachLuong = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị Menu
    public static void hienThiMenu () {
        System.out.println("******************* MENU NHẬP ĐIỂM *******************");
        System.out.println("1. Nhập lương nhân viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
        System.out.println("4. Thoát");
    }

    // Chức năng 1: Nhập lương nhân viên
    public static void nhapLuongNhanVien () {
        System.out.println("******************* Nhập lương nhân viên (Nhập -1 để kết thúc) *******************");

        while (true) {
            System.out.print("Nhập lương: ");
            long luong = scanner.nextLong();

            if (luong == -1) {
                System.out.println("Đã kết thúc quá trình nhập.");
                break;
            }

            // Kiểm tra miền giá trị (0 triệu đến 500 triệu)
            if (luong < 0 || luong > 500000000) {
                System.out.println(">> Cảnh báo: Lương phải có giá trị từ 0 đến 500 triệu. Mời bạn nhập lại!");
                continue;
            }

            // Thêm lương vào danh sách
            danhSachLuong.add(luong);

            // Xếp loại lương
            System.out.println(">> Phân loại: " + phanLoai(luong));
        }
    }

    // Phân loại mức thu nhập
    public static String phanLoai (long luong) {
        if (luong < 5000000) return "Thu nhập thấp.";
        else if (luong < 15000000) return "Thu nhập trung bình.";
        else if (luong < 50000000) return "Thu nhập khá.";
        else return "Thu nhập cao.";
    }

    // Chức năng 2: Hiển thị thống kê
    public static void hienThiThongKe () {
        if  (danhSachLuong.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
            return;
        }

        // Khai báo biến
        long tongLuong = 0;
        long maxLuong = danhSachLuong.getFirst();
        long minLuong = danhSachLuong.getFirst();

        for (long luong : danhSachLuong) {
            tongLuong += luong;

            if (luong > maxLuong) maxLuong = luong;
            if (luong < minLuong) minLuong = luong;
        }

        // Lương trung bình
        double luongTrungBinh = ((double) tongLuong / danhSachLuong.size());

        // Format lại số trước khi in ra
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.'); // Dấu phân cách hàng nghìn là dấu chấm
        symbols.setDecimalSeparator(',');  // Dấu phân cách thập phân là dấu phẩy

        DecimalFormat decimalFormat2 = new DecimalFormat("###,###.##", symbols);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        // In ra màn hình thống kê
        System.out.println("Số nhân viên đã nhập: " + danhSachLuong.size());
        System.out.println("Lương trung bình: " + decimalFormat2.format(luongTrungBinh));
        System.out.println("Lương cao nhất: " + decimalFormat.format(maxLuong));
        System.out.println("Lương thấp nhất: " + decimalFormat.format(minLuong));
        System.out.println("Tổng tiền lương: " + decimalFormat.format(tongLuong));
    }

    // Chức năng 3: Tính tổng số tiền thưởng cho nhân viên
    public static void tongTienThuong () {
        // Khai báo biến
        double tongThuong = 0;

        if (danhSachLuong.isEmpty()) {
            System.out.println("Chưa có dữ liệu để tính thưởng");
            return;
        }

        for (Long luong : danhSachLuong) {
            double phanTramLuong = phanTramLuong(luong);
            double tienThuong = luong * phanTramLuong;
            tongThuong += tienThuong;
        }

        // Format lại số trước khi in ra
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        // In ra màn hình tổng thưởng cho nhân viên
        System.out.println("Tổng thưởng cho nhân viên: " + decimalFormat.format(tongThuong));
    }

    // Hàm tính phần trăm lương
    public static double phanTramLuong (long luong) {
        if (luong < 5000000) return 0.05;
        else if (luong < 15000000) return 0.1;
        else if (luong < 50000000) return 0.15;
        else if (luong < 100000000) return 0.2;
        else return 0.25;
    }

    public static void main(String[] args) {
        int luaChon = 0;

        // Vòng lặp hiển thị Menu đến khi thoát
        do {
            // Hiển thị menu
            hienThiMenu();

            // Nhập lựa chọn menu
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            // Lựa chọn
            switch (luaChon) {
                case 1:
                    nhapLuongNhanVien();
                    break;
                case 2:
                    hienThiThongKe();
                    break;
                case 3:
                    tongTienThuong();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (luaChon != 4);
        scanner.close();
    }
}