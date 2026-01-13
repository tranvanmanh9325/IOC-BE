package Bai02;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai02 {
    // Sử dụng ArrayList để lưu trữ danh sách điểm số (độ dài động)
    static ArrayList<Double> danhSachDiem = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int suLuaChon;

        // Vòng lặp hiển thị Menu cho đến khi chọn Thoát
        do {
            hienThiMenu();
            System.out.print("Lựa chọn của bạn: ");

            // Kiểm tra người dùng có nhập số nguyên không
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số từ 1 đến 3!");
                System.out.print("Lựa chọn của bạn: ");
                scanner.next(); // Bỏ qua input sai
            }
            suLuaChon = scanner.nextInt();

            // Sử dụng switch-case để điều hướng
            switch (suLuaChon) {
                case 1:
                    chucNangNhapDiem();
                    break;
                case 2:
                    chucNangHienThiThongKe();
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
            System.out.println(); // Xuống dòng cho đẹp

        } while (suLuaChon != 3);
    }

    // --- Hàm hiển thị Menu ---
    public static void hienThiMenu() {
        System.out.println("**************** MENU NHẬP ĐIỂM ****************");
        System.out.println("1. Nhập điểm học viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Thoát");
    }

    // --- Chức năng 1: Nhập điểm ---
    public static void chucNangNhapDiem() {
        System.out.println("--- Nhập điểm học viên (Nhập -1 để kết thúc) ---");

        while (true) {
            System.out.print("Nhập điểm: ");
            // Kiểm tra input có phải số thực không
            if (!scanner.hasNextDouble()) {
                System.out.println(">> Cảnh báo: Vui lòng nhập số!");
                scanner.next(); // Xóa bộ đệm
                continue; // Quay lại đầu vòng lặp
            }

            double diem = scanner.nextDouble();

            // Điều kiện thoát
            if (diem == -1) {
                System.out.println("Đã kết thúc quá trình nhập.");
                break; // Thoát khỏi vòng lặp nhập
            }

            // Kiểm tra miền giá trị (0 - 10)
            if (diem < 0 || diem > 10) {
                System.out.println(">> Cảnh báo: Điểm phải nằm trong khoảng 0 - 10. Mời nhập lại!");
                continue; // Bỏ qua các lệnh dưới, quay lại nhập tiếp
            }

            // Thêm vào danh sách
            danhSachDiem.add(diem);

            // In ra xếp loại ngay lập tức
            System.out.println(">> Xếp loại: " + xepLoaiHocLuc(diem));
        }
    }

    // --- Chức năng 2: Thống kê ---
    public static void chucNangHienThiThongKe() {
        System.out.println("--- Thống kê kết quả ---");

        // Nếu chưa có học viên nào
        if (danhSachDiem.isEmpty()) {
            System.out.println(">> Chưa có dữ liệu!");
            return;
        }

        double tongDiem = 0;
        double max = danhSachDiem.get(0);
        double min = danhSachDiem.get(0);

        // Vòng lặp foreach duyệt danh sách
        for (Double d : danhSachDiem) {
            tongDiem += d;

            if (d > max) {
                max = d;
            }

            if (d < min) {
                min = d;
            }
        }

        double diemTrungBinh = tongDiem / danhSachDiem.size();

        // In kết quả
        System.out.println("Số học viên đã nhập: " + danhSachDiem.size());
        // Sử dụng %.2f để làm tròn 2 chữ số thập phân cho đẹp
        System.out.printf("Điểm trung bình: %.2f\n", diemTrungBinh);
        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
    }

    // --- Hàm phụ trợ: Xếp loại học lực ---
    public static String xepLoaiHocLuc(double diem) {
        if (diem < 5) {
            return "Yếu";
        } else if (diem < 7) {
            return "Trung Bình";
        } else if (diem < 8) {
            return "Khá";
        } else if (diem < 9) {
            return "Giỏi";
        } else {
            return "Xuất sắc";
        }
    }
}
