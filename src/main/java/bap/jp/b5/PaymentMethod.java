package bap.jp.b5;

import java.util.Scanner;

public enum PaymentMethod {
    CREDIT_CARD {
	@Override
	void processPayment(Scanner scanner, double amount) {
	    System.out.println("Xử lý thanh toán bằng thẻ tín dụng số tiền: " + amount + " VND");
	    System.out.print("Nhập số thẻ tín dụng: ");
	    String cardNumber = scanner.next();
	    System.out.print("Nhập CVV: ");
	    String cvv = scanner.next();
	    System.out.println("Đang xác minh thông tin thẻ: " + cardNumber + "...");
	    System.out.println("Thanh toán thành công bằng thẻ tín dụng!\n");
	}
    },
    PAYPAL {
	@Override
	void processPayment(Scanner scanner, double amount) {
	    System.out.println("Xử lý thanh toán qua PayPal số tiền: " + amount + " VND");
	    System.out.print("Nhập email PayPal: ");
	    String email = scanner.next();
	    System.out.println("Đang chuyển hướng đến cổng thanh toán PayPal cho email: " + email + "...");
	    System.out.println("Thanh toán thành công qua PayPal!\n");
	}
    },
    BANK_TRANSFER {
	@Override
	void processPayment(Scanner scanner, double amount) {
	    System.out.println("Xử lý thanh toán chuyển khoản ngân hàng số tiền: " + amount + " VND");
	    System.out.print("Nhập số tài khoản ngân hàng: ");
	    String accountNumber = scanner.next();
	    System.out.println("Đang kiểm tra thông tin tài khoản ngân hàng: " + accountNumber + "...");
	    System.out.println("Thanh toán thành công qua chuyển khoản ngân hàng!\n");
	}
    };

    abstract void processPayment(Scanner scanner, double amount);
}
