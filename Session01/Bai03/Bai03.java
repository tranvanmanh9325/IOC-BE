package Bai03;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập phân số thứ nhất (a/b) ---
        System.out.print("Nhập tử số 1 (a): ");
        int a = scanner.nextInt();
        System.out.print("Nhập mẫu số 1 (b): ");
        int b = scanner.nextInt();

        // Nhập phân số thứ hai (c/d) ---
        System.out.print("Nhập tử số 2 (c): ");
        int c = scanner.nextInt();
        System.out.print("Nhập mẫu số 2 (d): ");
        int d = scanner.nextInt();

        // --- Tính toán theo công thức ---
        // Tử số mới = a*d + b*c
        int tuSoKetQua = (a * d) + (b * c);

        // Mẫu số mới = b*d
        int mauSoKetQua = b * d;

        // --- In kết quả ra màn hình ---
        System.out.println("Kết quả: " + tuSoKetQua + "/" + mauSoKetQua);

        // Đóng scanner
        scanner.close();
    }
}