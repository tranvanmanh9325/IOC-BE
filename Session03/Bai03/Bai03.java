package Bai03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai03 {
    // Lưu danh sách lương
    static ArrayList<Double> danhSachLuong = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Định dạng hiển thị tiền (ví dụ: 10,000,000 VND)
    static DecimalFormat currencyFormat = new DecimalFormat("###,###");

    public static void main(String[] args) {
        int suLuaChon;

        do {
            hienThiMenu();
            System.out.print("Lựa chọn của bạn: ");

            // Validate nhập menu
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số từ 1 đến 4!");
                System.out.print("Lựa chọn của bạn: ");
                scanner.next();
            }
            suLuaChon = scanner.nextInt();

            switch (suLuaChon) {
                case 1:
                    chucNangNhapLuong();
                    break;
                case 2:
                    chucNangHienThiThongKe();
                    break;
                case 3:
                    chucNangTinhTongThuong();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0); // Yêu cầu đề bài dùng System.exit(0)
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
            System.out.println();

        } while (true); // Vòng lặp vô hạn, thoát bằng case 4
    }

    // --- Menu ---
    public static void hienThiMenu() {
        System.out.println("========== MENU NHẬP LƯƠNG ==========");
        System.out.println("1. Nhập lương nhân viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Tính tổng số tiền thưởng nhân viên");
        System.out.println("4. Thoát");
    }

    // --- Chức năng 1: Nhập lương ---
    public static void chucNangNhapLuong() {
        System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");

        while (true) {
            System.out.print("Nhập lương: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Lương không hợp lệ. Nhập lại.");
                scanner.next();
                continue;
            }

            double luong = scanner.nextDouble();

            if (luong == -1) {
                break;
            }

            // Kiểm tra miền giá trị (0 - 500 triệu)
            // 500 triệu = 500,000,000
            if (luong < 0 || luong > 500000000) {
                System.out.println("Lương phải có giá trị từ 0 đến 500 triệu. Nhập lại.");
                continue;
            }

            danhSachLuong.add(luong);
            System.out.println("-> Phân loại: " + phanLoaiThuNhap(luong));
        }
    }

    // --- Chức năng 2: Thống kê ---
    public static void chucNangHienThiThongKe() {
        System.out.println("--- Thống kê ---");
        if (danhSachLuong.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }

        double tongLuong = 0;
        double max = danhSachLuong.get(0);
        double min = danhSachLuong.get(0);

        for (Double luong : danhSachLuong) {
            tongLuong += luong;
            if (luong > max) max = luong;
            if (luong < min) min = luong;
        }

        double trungBinh = tongLuong / danhSachLuong.size();

        // In kết quả có định dạng tiền tệ
        System.out.println("Số nhân viên: " + danhSachLuong.size());
        System.out.println("Tổng lương: " + currencyFormat.format(tongLuong) + " VND");
        System.out.println("Lương trung bình: " + currencyFormat.format(trungBinh) + " VND");
        System.out.println("Lương cao nhất: " + currencyFormat.format(max) + " VND");
        System.out.println("Lương thấp nhất: " + currencyFormat.format(min) + " VND");
    }

    // --- Chức năng 3: Tính tổng tiền thưởng ---
    public static void chucNangTinhTongThuong() {
        if (danhSachLuong.isEmpty()) {
            System.out.println("Chưa có dữ liệu để tính thưởng!");
            return;
        }

        double tongThuong = 0;
        for (Double luong : danhSachLuong) {
            double phanTramThuong = layPhanTramThuong(luong);
            double tienThuong = luong * phanTramThuong;
            tongThuong += tienThuong;
        }

        System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
        System.out.println("Tổng tiền thưởng nhân viên: " + currencyFormat.format(tongThuong) + " VND");
    }

    // --- Hàm phụ: Phân loại thu nhập (Cho Chức năng 1) ---
    public static String phanLoaiThuNhap(double luong) {
        // Đơn vị tính: triệu (1 triệu = 1,000,000)
        double trieu = 1000000;

        if (luong < 5 * trieu) {
            return "Thu nhập thấp";
        } else if (luong < 15 * trieu) {
            return "Thu nhập trung bình";
        } else if (luong <= 50 * trieu) {
            return "Thu nhập khá";
        } else {
            return "Thu nhập cao";
        }
    }

    // --- Hàm phụ: Lấy % thưởng (Cho Chức năng 3) ---
    public static double layPhanTramThuong(double luong) {
        double trieu = 1000000;

        if (luong < 5 * trieu) {
            return 0.05; // 5%
        } else if (luong < 15 * trieu) {
            return 0.10; // 10%
        } else if (luong < 50 * trieu) {
            return 0.15; // 15%
        } else if (luong < 100 * trieu) {
            return 0.20; // 20%
        } else {
            return 0.25; // 25% (> 100M)
        }
    }
}
