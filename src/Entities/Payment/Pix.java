package Entities.Payment;

public class Pix implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment with Pix done successfully.");
    }
}
