package Bai02;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Bai02 {
    // Sử dụng ArrayList để lưu trữ danh sách điểm số
    static ArrayList<Double> danhSachDiem =  new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị menu
    public static void hienThiMenu () {
        System.out.println("******************* MENU NHẬP ĐIỂM *******************");
        System.out.println("1. Nhập điểm học viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Thoát");
    }

    // Hàm chức năng nhập điểm
    public static void chucNangNhapDiem() {
        System.out.println("******************* Nhập điểm học viên (Nhập -1 để kết thúc) *******************");

        while (true) {
            System.out.print("Nhập điểm: ");
            scanner.useLocale(Locale.US);

            double diem = scanner.nextDouble();

            if (diem == -1) {
                System.out.println("Đã kết thúc quá trình nhập.");
                break;
            }

            // Kiểm tra miền giá trị (0 - 10)
            if (diem < 0 || diem > 10) {
                System.out.println(">> Cảnh báo: Điểm phải nằm trong khoảng 0 - 10. Mời nhập lại.");
                continue;
            }

            // Thêm điểm vào danh sách
            danhSachDiem.add(diem);

            // In ra xếp loại học lực
            System.out.println(">> Xếp loại: " + xepLoaiHocLuc(diem));

        }
    }

    // Hàm chức năng hiển thị thống kê
    public static void hienThiThongKe () {
        System.out.println("******************* Thống kê kết quả *******************");

        // Nếu chưa có học viên nào
        if (danhSachDiem.isEmpty()) {
            System.out.println(">> Chưa có dữ liệu.");
            return;
        }

        // Khai báo biến
        double tongDiem = 0;
        double maxDiem = danhSachDiem.getFirst();
        double minDiem = danhSachDiem.getFirst();

        for (Double diem : danhSachDiem) {
            tongDiem += diem;

            // Tìm điểm cao nhất
            if (diem > maxDiem) {
                maxDiem = diem;
            }

            // Tìm điểm thấp nhất
            if (diem < minDiem) {
                minDiem = diem;
            }
        }
        // Tính điểm trung bình
        double diemTrungBinh = tongDiem / danhSachDiem.size();

        // In kết quả ra màn hình
        System.out.println("Số học viên đã nhập: " + danhSachDiem.size());
        System.out.printf("Điểm trung bình: %.2f\n", diemTrungBinh);
        System.out.printf("Điểm cao nhất: %.2f\n", maxDiem);
        System.out.printf("Điểm thấp nhất: %.2f\n", minDiem);
    }

    public static String xepLoaiHocLuc (double diem) {
        if (diem < 5) {
            return "Yếu";
        } else if (diem < 7) {
            return "Trung bình";
        } else if (diem < 8) {
            return "Khá";
        } else if (diem < 9) {
            return "Giỏi";
        } else {
            return "Xuất sắc";
        }
    }

    public static void main(String[] args) {
        int luaChon;

        // Vòng lặp hiển thị Menu cho đến khi chọn thoát
        do {
            hienThiMenu();

            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            // Dùng switch case để điều hướng
            switch (luaChon) {
                case 1:
                    chucNangNhapDiem();
                    break;
                case 2:
                    hienThiThongKe();
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.print("Lựa chọn của bạn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon != 3);

        scanner.close();
    }
}