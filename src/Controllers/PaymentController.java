package Controllers;

import Services.PaymentService;

public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    public void pay(int type) {
        service.pay(type);
    }
}
