package Entities.Payment;

public class Card implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment with Card done successfully.");
    }
}
