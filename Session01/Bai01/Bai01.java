public static double dien_tich(int r) {
    return r * r * Math.PI;
}

void main() {
    Scanner sc = new Scanner(System.in);
    // Nhập bán kính
    System.out.print("Nhập bán kính đường tròn: ");
    int r = sc.nextInt();

    // Hàm tính diện tích hình tròn
    double result = dien_tich(r);

    // In ra kết quả màn hình
    System.out.printf("Diện tích hình tròn: %.2f", result);

    sc.close();
}