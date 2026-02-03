import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập một số nguyên từ 1 đến 12 (tương ứng với tháng)
        System.out.print("Nhập một số nguyên từ 1 đến 12 (tương ứng với tháng): ");
        int thang =  scanner.nextInt();

        switch(thang){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("Tháng " + thang + " có 31 ngày.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Tháng " + thang + " có 30 ngày.");
                break;
            case 2:
                System.out.print("Tháng 2 có 28 hoặc 29 ngày.");
            default:
                System.out.print("Tháng không hợp lệ.");
        }

        // Đóng scanner
        scanner.close();
    }
}