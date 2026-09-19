package Dao;

import Entities.Transaction.Transaction;
import Interfaces.BaseTransactionDao;

import java.util.ArrayList;
import java.util.List;

public class TransactionDao implements BaseTransactionDao {

    private final List<Transaction> transactions = new ArrayList<>();
    private int id = 1;

    @Override
    public void save(Transaction transaction) {
        transaction.setId(id++);
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public void update(Transaction updatedTransaction) {

        for (Transaction transaction : transactions) {

            if (transaction.getId() == updatedTransaction.getId()) {

                transaction.setDescription(updatedTransaction.getDescription());
                transaction.setAmount(updatedTransaction.getAmount());
                transaction.setDate(updatedTransaction.getDate());
                transaction.setCategory(updatedTransaction.getCategory());

                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
    }
}
