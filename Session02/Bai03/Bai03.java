import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        // 1. Nhập liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên N: ");
        int n = scanner.nextInt();

        // Lưu lại giá trị gốc để in ra nếu cần (tuỳ chọn)
        int originalN = n;

        // 2. Xử lý số âm: Nếu n âm, chuyển thành dương
        // Cách 1: Dùng hàm Math.abs(n)
        // Cách 2: Dùng if (n < 0) n = -n;
        if (n < 0) {
            n = -n;
        }

        int sum = 0;

        // 3. Sử dụng vòng lặp để tách và cộng các chữ số
        // Vòng lặp chạy khi n vẫn còn lớn hơn 0
        while (n > 0) {
            int digit = n % 10; // Lấy chữ số cuối cùng (phần dư)
            sum += digit;       // Cộng vào tổng
            n = n / 10;         // Bỏ chữ số vừa lấy đi (phần nguyên)
        }

        // 4. In ra kết quả
        System.out.println("Tổng các chữ số của " + originalN + " là: " + sum);
    }
}