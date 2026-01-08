package Bai04;

import java.util.Scanner;

public class Bai04 {
    static void main(String[] args) {
        // 1. Khai báo các biến kiểu float theo yêu cầu
        float width, height;
        float area, perimeter;

        // Tạo đối tượng Scanner để nhập dữ liệu
        Scanner scanner = new Scanner(System.in);

        // 2. Nhập dữ liệu từ bàn phím
        System.out.print("Nhập chiều rộng (width): ");
        width = scanner.nextFloat();

        System.out.print("Nhập chiều cao (height): ");
        height = scanner.nextFloat();

        // 3. Tính diện tích và chu vi
        // Công thức: Diện tích = chiều rộng * chiều cao
        area = width * height;

        // Công thức: Chu vi = 2 * (chiều rộng + chiều cao)
        perimeter = 2 * (width + height);

        // 4. In kết quả ra màn hình
        // Sử dụng printf và %.2f để làm tròn 2 chữ số thập phân như đề bài (7.00, 11.00)
        System.out.printf("Diện tích : %.2f\n", area);
        System.out.printf("Chu vi : %.2f\n", perimeter);

        // Đóng scanner
        scanner.close();
    }
}