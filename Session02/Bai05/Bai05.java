import java.util.Scanner;

public class Bai05 {
    // Hàm đọc số
    public static String docSo (int n) {
        return switch (n) {
            case 0 -> "không";
            case 1 -> "một";
            case 2 -> "hai";
            case 3 -> "ba";
            case 4 -> "bốn";
            case 5 -> "năm";
            case 6 -> "sáu";
            case 7 -> "bảy";
            case 8 -> "tám";
            case 9 -> "chín";
            default -> "";
        };
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số nguyên (100-999): ");
        int n = scanner.nextInt();

        if (n < 100 || n > 999) {
            System.out.print("Số nhập vào không hợp lệ");
        } else {
            int hundreds =  n / 100; // Hàng trăm
            int tens = (n % 100) / 10; // Hàng chục
            int units = n % 10; // Hàng đơn vị

            // In ra màn hình
            System.out.print(docSo(hundreds)+ " trăm");

            if (tens == 0 && units == 0) {
                return;
            } else if (tens == 0) {
                System.out.print(" lẻ " + docSo(units));
            } else if (tens == 1) {
                System.out.print(" mười");
                if (units == 1) {
                    System.out.print(" một");
                } else if (units == 5) {
                    System.out.print(" lăm");
                } else if (units != 0) {
                    System.out.print(" " +  docSo(units));
                }
            } else {
                System.out.print(" " + docSo(tens) + " mươi");

                if (units == 1) {
                    System.out.print(" mốt");
                } else if (units == 5) {
                    System.out.print(" lăm");
                } else if (units != 0) {
                    System.out.print(" " +  docSo(units));
                }
            }

            // Xuống dòng sau khi in xong
            System.out.println();
        }

        // Đóng scanner
        scanner.close();
    }
}