package Entities.Payment;

public class LoggingPaymentDecorator implements Payment {

    private final Payment payment;

    public LoggingPaymentDecorator(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("LOG: Starting payment with " + payment.getClass().getSimpleName() + ".");
        payment.pay();
        System.out.println("LOG: Payment with " + payment.getClass().getSimpleName() + " completed.");
    }
}
