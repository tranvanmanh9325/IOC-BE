import java.util.Scanner;

public class Bai03 {

    // Hàm tính tổng các chữ số của N
    public static int sum (int n) {
        int sum = 0;
        while (n > 0) {
            int du = n % 10;
            sum += du;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        // Một số nguyên N, có thể âm hoặc dương, được nhập từ bàn phím.
        System.out.print("Nhập một số nguyên N: ");
        int n = scanner.nextInt();

        if (n < 0) {
            n *= -1;
        }

        // Hàm tính tổng các chữ số của N
        int tong = sum(n);

        // In kết quả ra màn hình
        System.out.print("Tổng các chữ số là: " + tong);

        // Đóng scanner
        scanner.close();
    }
}