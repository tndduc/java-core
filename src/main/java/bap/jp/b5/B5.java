package bap.jp.b5;

import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	while (true) {
	    System.out.println("Chào mừng đến với hệ thống thanh toán trực tuyến!");
	    System.out.println("Chọn phương thức thanh toán: 1 - Thẻ tín dụng, 2 - PayPal, 3 - Chuyển khoản ngân hàng, 4 - Thoát");
	    int choice = scanner.nextInt();

	    if (choice == 4) {
		System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Hẹn gặp lại!");
		break;
	    }

	    System.out.print("Nhập số tiền thanh toán: ");
	    double amount = scanner.nextDouble();

	    PaymentMethod method = null;
	    switch (choice) {
		case 1: method = PaymentMethod.CREDIT_CARD; break;
		case 2: method = PaymentMethod.PAYPAL; break;
		case 3: method = PaymentMethod.BANK_TRANSFER; break;
		default: System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!"); continue;
	    }

	    method.processPayment(scanner, amount);
	}

	scanner.close();
    }
}