import java.util.Scanner;

public class Bai01 {

    // Hàm tính tổng từ 1 đến N
    public static int sum (int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên dương N: ");
        int n = scanner.nextInt();

        // Kiểm tra Nếu người dùng nhập số không hợp lệ (ví dụ: số âm hoặc số 0), hiển thị thông báo lỗi “Số nhập vào không hợp lệ”
        if (n <= 0) {
            System.out.print("Số nhập vào không hợp lệ");
        } else {
            // Xử lý
            int sum = sum(n);

            // In kết quả ra màn hình
            System.out.println("Tổng các số từ 1 đến "+ n + " là: " + sum);
        }

        // Đóng scanner
        scanner.close();
    }
}