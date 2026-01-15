import java.util.Scanner;

public class SumEvenOdd2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Nhập kích thước mảng 2 chiều
        System.out.print("Nhập số hàng của mảng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int cols = sc.nextInt();
        
        // Khởi tạo mảng 2 chiều
        int[][] arr = new int[rows][cols];
        
        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        
        // Hiển thị mảng vừa nhập
        System.out.println("\nMảng 2 chiều vừa nhập:");
        printArray(arr);
        
        // Tính tổng các số chẵn và số lẻ
        int sumEven = 0;
        int sumOdd = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumEven += arr[i][j];
                } else {
                    sumOdd += arr[i][j];
                }
            }
        }
        
        // Hiển thị kết quả
        System.out.println("\nKết quả:");
        System.out.println("Tổng các số chẵn: " + sumEven);
        System.out.println("Tổng các số lẻ: " + sumOdd);
        
        sc.close();
    }
    
    // Phương thức in mảng 2 chiều
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}