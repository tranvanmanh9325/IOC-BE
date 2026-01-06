// Hàm tính tổng hai số nguyên
public static int tong (int firstNumber,  int secondNumber) {
    return firstNumber + secondNumber;
}

// Hàm tính hiệu hai số nguyên
public static int hieu (int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
}

// Hàm tính tích hai số nguyên
public static int tich (int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
}

// Hàm tính thương hai số nguyên
public static int thuong (int firstNumber, int secondNumber) {
    return firstNumber / secondNumber;
}

// Hàm tính phần dư hai số nguyên
public static int phan_du (int firstNumber, int secondNumber) {
    return firstNumber % secondNumber;
}

void main() {

    // Khai báo scanner
    Scanner sc = new Scanner(System.in);

    // Khai báo hai số nguyên firstNumber và secondNumber có kiểu int
    System.out.print("Nhập số thứ nhất (firstNumber): ");
    int firstNumber =  sc.nextInt();
    System.out.print("Nhập số thứ hai (secondNumber ): ");
    int secondNumber = sc.nextInt();

    // Hàm xử lý logic
    int tong = tong(firstNumber, secondNumber);
    int hieu = hieu(firstNumber, secondNumber);
    int tich  = tich(firstNumber, secondNumber);
    int thuong = thuong(firstNumber, secondNumber);
    int pha_du = phan_du(firstNumber, secondNumber);

    // In kết quả
    System.out.print("\n\n");
    System.out.println("--- Kết quả ---");
    System.out.println("firstNumber: " + firstNumber);
    System.out.println("secondNumber: " + secondNumber);
    System.out.println("Tổng = " + tong);
    System.out.println("Hiệu = " + hieu);
    System.out.println("Tích = " + tich);
    System.out.println("Thuong = " + thuong);
    System.out.print("Phần dư = " + pha_du);
    sc.close();
}