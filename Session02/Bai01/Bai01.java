import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        // 1. Khởi tạo đối tượng Scanner để nhận dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // 2. Yêu cầu người dùng nhập N
        System.out.print("Nhập vào một số nguyên dương N: ");
        int n = scanner.nextInt();

        // 3. Kiểm tra điều kiện đầu vào (Validate input)
        // Yêu cầu: Nếu số âm hoặc bằng 0 thì báo lỗi
        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            // 4. Xử lý tính tổng dùng vòng lặp for
            long sum = 0; // Sử dụng long để tránh tràn số nếu tổng quá lớn
            for (int i = 1; i <= n; i++) {
                sum += i; // Cộng dồn giá trị i vào biến sum
            }

            // 5. Hiển thị kết quả ra màn hình
            System.out.println("Tổng các số từ 1 đến " + n + " là: " + sum);
        }

        // Đóng scanner
        scanner.close();
    }
}