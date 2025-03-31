package bap.jp.b5;

import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Nhập số tiền thanh toán: ");
	double amount = scanner.nextDouble();

	System.out.println("Chọn phương thức thanh toán: 1. Thẻ tín dụng  2. PayPal  3. Chuyển khoản ngân hàng");
	int choice = scanner.nextInt();

	PaymentMethod method = PaymentMethod.values()[choice - 1];
	method.processPayment(amount);

	scanner.close();
    }
}
