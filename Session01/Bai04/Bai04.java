package Bai04;

import java.util.Locale;
import java.util.Scanner;

public class Bai04 {

    public static void main(String[] args) {
        // Tạp scanner
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        // Nhập chiều dài hình chữ nhật
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        float width = scanner.nextFloat();

        // Nhập chiều rộng hình chữ nhật
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        float height = scanner.nextFloat();

        float dien_tich = width * height;
        float chu_vi = (width + height) * 2;

        // In ra màn hình
        System.out.printf(Locale.US, "Diện tích: %.2f \n",  dien_tich);
        System.out.printf(Locale.US, "Chu vi: %.2f",   chu_vi );

        // Đóng scanner
        scanner.close();
    }
}