import java.util.Scanner;

public class SelectionSortAndSearch {
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
        
        // Sắp xếp mảng giảm dần bằng Selection Sort
        selectionSortDescending(arr);
        
        // In mảng sau khi sắp xếp
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        printArray(arr);
        
        // Tìm kiếm số
        System.out.print("\nNhập số cần tìm: ");
        int target = sc.nextInt();
        
        // Tìm kiếm tuyến tính
        int linearResult = linearSearch(arr, target);
        if (linearResult != -1) {
            System.out.println("Tìm kiếm tuyến tính: Số " + target + " có tại vị trí " + linearResult);
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy số " + target);
        }
        
        // Tìm kiếm nhị phân (mảng đã sắp xếp giảm dần)
        int binaryResult = binarySearchDescending(arr, target);
        if (binaryResult != -1) {
            System.out.println("Tìm kiếm nhị phân: Số " + target + " có tại vị trí " + binaryResult);
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy số " + target);
        }
        
        sc.close();
    }
    
    // Phương thức sắp xếp chọn theo thứ tự giảm dần
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử lớn nhất trong phần chưa sắp xếp
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            
            // Hoán đổi phần tử lớn nhất với phần tử đầu tiên của phần chưa sắp xếp
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
    
    // Phương thức tìm kiếm tuyến tính
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Không tìm thấy
    }
    
    // Phương thức tìm kiếm nhị phân cho mảng giảm dần
    public static int binarySearchDescending(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Vì mảng giảm dần, nếu target lớn hơn mid thì tìm bên trái
            if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1; // Không tìm thấy
    }
    
    // Phương thức in mảng
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}