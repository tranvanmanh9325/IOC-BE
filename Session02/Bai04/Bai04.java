import java.util.Scanner;

public class Bai04 {
    public static void main(String[] args) {
        // Tao scanner
        Scanner scanner = new Scanner(System.in);

        // Nhập lần lượt độ dài mỗi cạnh
        System.out.print("Nhập độ dài cạnh thứ 1: ");
        int canh1 = scanner.nextInt();

        System.out.print("Nhập độ dài cạnh thứ 2: ");
        int canh2 = scanner.nextInt();

        System.out.print("Nhập độ dài cạnh thứ 3: ");
        int canh3 = scanner.nextInt();

        if (canh1 + canh2 > canh3 && canh1 + canh3 > canh2 && canh2 + canh3 > canh1) {
            if (canh1*canh1 + canh2*canh2 == canh3*canh3 || canh1*canh1 + canh3*canh3 == canh2*canh2 || canh2*canh2 + canh3*canh3 == canh1*canh1) {
                System.out.print("Đây là tam giác vuông.");
            } else if (canh1 == canh2 && canh2 == canh3) {
                System.out.print("Đây là tam giác đều.");
            } else if (canh1 == canh2 || canh1 == canh3 || canh2 == canh3) {
                System.out.print("Đây là tam giác cân.");
            }
        } else {
            System.out.print("Ba cạnh không tạo thành tam giác.");
        }

        // Đóng scanner
        scanner.close();
    }
}