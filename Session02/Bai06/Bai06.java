import java.util.Scanner;

public class Bai06 {
    // Hàm xử lý Armstrong
    public static boolean isArmstrong (int number) {
        if (number < 0) return false;

        if (number > 0 && number < 9)  return true;
        int sum =0;

        // Tính số lượng chữ số (k)
        // Cách chuyển sang String để đếm độ dài là cách dễ hiểu nhất
        int k = String.valueOf(number).length();

        // Tính tổng lũy thừa bậc k
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, k);
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        // Nhập một số nguyên dương N từ bàn phím
        int n = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Nhập vào số nguyên dương N: ");
                String input = scanner.nextLine();
                n = Integer.parseInt(input);

                if (n > 0) {
                    isValid = true;
                } else {
                    System.out.print("Số nhập vào không hợp lệ. Vui lòng nhập số nguyên dương.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập đúng định dạng số.");
            }
        }

        System.out.print("Các số Armstrong từ 0 đến " + n + " là: ");

        // Duyệt qua các số từ 0 đến n
        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

        // Đóng scanner
        scanner.close();
    }
}
