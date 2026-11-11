package Observers;

import Entities.Transaction.Transaction;

public interface TransactionObserver {

    void onTransactionUpdated(Transaction transaction);
}
