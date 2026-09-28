package Services;

import Entities.Payment.Payment;
import Factories.PaymentFactory;

public class PaymentService {

    public void pay(int type) {
        Payment payment = PaymentFactory.create(type);

        if (payment == null) {
            System.out.println("ERROR: Invalid payment type.");
            return;
        }

        payment.pay();
    }
}
