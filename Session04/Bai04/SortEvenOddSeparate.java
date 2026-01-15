import java.util.Scanner;

public class SortEvenOddSeparate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Nhập số phần tử của mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        
        // Kiểm tra mảng rỗng
        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            sc.close();
            return;
        }
        
        // Khởi tạo mảng
        int[] arr = new int[n];
        
        // Nhập giá trị các phần tử
        System.out.println("Nhập giá trị các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        // In mảng ban đầu
        System.out.println("\nMảng ban đầu:");
        printArray(arr);
        
        // Sắp xếp mảng: số chẵn đứng trước, số lẻ đứng sau
        sortEvenOdd(arr);
        
        // In mảng sau khi sắp xếp
        System.out.println("\nMảng sau khi sắp xếp (số chẵn trước, số lẻ sau):");
        printArray(arr);
        
        // Hiển thị chi tiết
        displayDetails(arr);
        
        sc.close();
    }
    
    /**
     * Sắp xếp mảng sao cho các số chẵn đứng trước, số lẻ đứng sau
     * Giữ nguyên thứ tự trong từng nhóm
     */
    public static void sortEvenOdd(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int evenIndex = 0;
        
        // Đếm số phần tử chẵn
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }
        
        // Đưa các số chẵn vào đầu mảng
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[evenIndex] = arr[i];
                evenIndex++;
            }
        }
        
        // Đưa các số lẻ vào cuối mảng
        int oddIndex = evenCount;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[oddIndex] = arr[i];
                oddIndex++;
            }
        }
        
        // Sao chép kết quả về mảng ban đầu
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
    
    /**
     * Hiển thị chi tiết các số chẵn và số lẻ
     */
    public static void displayDetails(int[] arr) {
        System.out.println("\nChi tiết:");
        
        // Tách số chẵn
        System.out.print("Số chẵn đứng trước: ");
        boolean hasEven = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
                hasEven = true;
            }
        }
        if (!hasEven) {
            System.out.print("(không có)");
        }
        System.out.println();
        
        // Tách số lẻ
        System.out.print("Số lẻ đứng sau: ");
        boolean hasOdd = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
                hasOdd = true;
            }
        }
        if (!hasOdd) {
            System.out.print("(không có)");
        }
        System.out.println();
    }
    
    /**
     * In mảng
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}