package Bai06;

import java.util.Locale;
import java.util.Scanner;

public class Bai06 {

    // Hàm tính quãng đường đi được
    public static float quang_duong (int van_toc, float thoi_gian) {
        return (thoi_gian * (float) van_toc);
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // Nhập vận tốc (km/h)
        System.out.print("Nhập vận tốc (km/h): ");
        int van_toc = scanner.nextInt();

        // Nhập thời gian đi (giờ)
        System.out.print("Nhập thời gian đi (giờ): ");
        float thoi_gian = scanner.nextFloat();

        // Hàm tính quãng đường đi được
        float quang_duong = quang_duong(van_toc, thoi_gian);

        // In ra màn hình
        System.out.printf("Quãng đường = %.0f",  quang_duong);

        // Đóng scanner
        scanner.close();
    }
}
