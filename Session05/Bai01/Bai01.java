package Bai01;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        // Tạo scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("NHập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();

        // Khai báo mảng
        int[] input = new int[n];

        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " +  (i + 1) + ": ");
            input[i] = scanner.nextInt();
        }

        // Hàm Bubble Sort

        // In kết quả ra màn hình
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");


        // Đóng scanner
        scanner.close();
    }
}
