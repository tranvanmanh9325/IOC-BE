import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập vào số tháng
        System.out.print("Nhập vào một số nguyên (1-12): ");
        int month = scanner.nextInt();

        // Sử dụng cấu trúc switch-case để kiểm tra tháng
        switch (month) {
            // Các tháng có 31 ngày
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày.");
                break;

            // Các tháng có 30 ngày
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày.");
                break;

            // Tháng 2 đặc biệt
            case 2:
                System.out.println("Tháng " + month + " có 28 hoặc 29 ngày.");
                break;

            // Trường hợp không hợp lệ (nhập số ngoài khoảng 1-12)
            default:
                System.out.println("Tháng không hợp lệ.");
                break;
        }

        // Đóng scanner
        scanner.close();
    }
}