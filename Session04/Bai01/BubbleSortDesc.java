

import java.util.Scanner;

public class BubbleSortDesc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Nhập kích thước mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        
        // Khởi tạo mảng
        int[] arr = new int[n];
        
        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        // In mảng trước khi sắp xếp
        System.out.println("\nMảng trước khi sắp xếp:");
        printArray(arr);
        
        // Sắp xếp mảng giảm dần bằng Bubble Sort
        bubbleSortDescending(arr);
        
        // In mảng sau khi sắp xếp
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        printArray(arr);
        
        sc.close();
    }
    
    // Phương thức sắp xếp nổi bọt theo thứ tự giảm dần
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        
        // Duyệt qua tất cả các phần tử
        for (int i = 0; i < n - 1; i++) {
            // Đưa phần tử lớn nhất về cuối trong mỗi lần lặp
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh hai phần tử kề nhau
                // Nếu phần tử trước nhỏ hơn phần tử sau thì đổi chỗ
                if (arr[j] < arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Phương thức in mảng
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}