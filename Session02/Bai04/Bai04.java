import java.util.Scanner;

public class Bai04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập ba số nguyên dương
        System.out.println("Nhập cạnh thứ nhất: ");
        int a = scanner.nextInt();
        System.out.println("Nhập cạnh thứ hai: ");
        int b = scanner.nextInt();
        System.out.println("Nhập cạnh thứ ba: ");
        int c = scanner.nextInt();

        // 2. Kiểm tra tính hợp lệ của tam giác
        // Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại
        if (a + b > c && a + c > b && b + c > a) {

            // 3. Phân loại tam giác theo thứ tự yêu cầu

            // Tam giác đều: 3 cạnh bằng nhau
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            }
            // Tam giác cân: 2 cạnh bằng nhau
            // (Lưu ý: Tam giác đều cũng là tam giác cân, nên phải kiểm tra đều trước)
            else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân.");
            }
            // Tam giác vuông: Định lý Pythagoras (a^2 + b^2 = c^2)
            else if (a * a == b * b + c * c ||
                    b * b == a * a + c * c ||
                    c * c == a * a + b * b) {
                System.out.println("Đây là tam giác vuông.");
            }
            // Tam giác thường: Các trường hợp còn lại
            else {
                System.out.println("Đây là tam giác thường.");
            }

        } else {
            // Trường hợp không hợp lệ
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        scanner.close();
    }
}