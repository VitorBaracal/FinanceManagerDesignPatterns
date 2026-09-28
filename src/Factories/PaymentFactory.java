package Factories;

import Entities.Payment.Card;
import Entities.Payment.Payment;
import Entities.Payment.Pix;

public class PaymentFactory {

    public static Payment create(int type) {
        if (type == 1) {
            return new Card();
        }

        if (type == 2) {
            return new Pix();
        }

        return null;
    }
}
