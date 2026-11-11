package Interfaces;

import Entities.Transaction.Transaction;

import java.util.List;

public interface BaseTransactionDao {
    public void save(Transaction transaction);

    public List<Transaction> getAllTransactions();

    void update(Transaction transaction);

    public void delete(int id);
}
