package Observers;

import Entities.Transaction.Transaction;

public class PrintTransactionObserver implements TransactionObserver {

    @Override
    public void onTransactionUpdated(Transaction transaction) {

        System.out.println("Observer: " + transaction);

    }
}
