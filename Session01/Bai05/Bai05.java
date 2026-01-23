package Bai05;

import java.util.Locale;
import java.util.Scanner;

public class Bai05 {

    public static float BMI (int can_nang, float chieu_cao) {
        return ((float) can_nang / (chieu_cao * chieu_cao));
    }

    public static void main(String[] args) {

        // Tạo scanner
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // Nhập cân nặng (kg)
        System.out.print("Nhập cân nặng (kg) = ");
        int can_nang = scanner.nextInt();

        // Nhập chiều cao (m)
        System.out.print("Nhập chiều cao (m) = ");
        float chieu_cao = scanner.nextFloat();

        // Hàm tính chỉ số BMI
        float BMI = BMI (can_nang, chieu_cao);

        // In ra màn hình
        System.out.printf(Locale.US, "Chỉ số BMI = %.2f", BMI);

        // Đóng scanner
        scanner.close();
    }
}
