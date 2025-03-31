package bap.jp.b5;

public enum PaymentMethod {
    CREDIT_CARD {
	@Override
	public void processPayment(double amount) {
	    System.out.println("Đang xử lý thanh toán bằng thẻ tín dụng với số tiền: " + amount + " VNĐ");
	}
    },
    PAYPAL {
	@Override
	public void processPayment(double amount) {
	    System.out.println("Đang xử lý thanh toán bằng PayPal với số tiền: " + amount + " VNĐ");
	}
    },
    BANK_TRANSFER {
	@Override
	public void processPayment(double amount) {
	    System.out.println("Đang xử lý thanh toán chuyển khoản ngân hàng với số tiền: " + amount + " VNĐ");
	}
    };

    public abstract void processPayment(double amount);
}
