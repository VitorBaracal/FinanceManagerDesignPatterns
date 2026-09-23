package Services;

import Dao.TransactionDao;
import Entities.Transaction.Expense;
import Entities.Transaction.Income;
import Entities.Transaction.Transaction;

import java.util.List;

public class TransactionService {

    private final TransactionDao transactionDao;
    private final AccountService accountService;

    public TransactionService(TransactionDao transactionDao, AccountService accountService) {this.transactionDao = transactionDao; this.accountService = accountService;}

    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public String addTransaction(Transaction transaction) {

        if (transaction.getDescription() == null ||
                transaction.getDescription().trim().isEmpty()) {

            return "ERROR: Transaction description cannot be empty.";
        }

        String description = transaction.getDescription().trim();
        transaction.setDescription(description);

        transactionDao.save(transaction);

        if (transaction instanceof Income) {
            accountService.increaseBalance(transaction.getAccountId(), transaction.getAmount());
        } else if (transaction instanceof Expense) {
            accountService.decreaseBalance(transaction.getAccountId(), transaction.getAmount());
        }

        return "SUCCESS: Transaction '" + description + "' created successfully.";
    }

    public String updateTransaction(Transaction transaction) {

        if (transaction.getDescription() == null ||
                transaction.getDescription().trim().isEmpty()) {

            return "ERROR: Transaction description cannot be empty.";
        }

        String description = transaction.getDescription().trim();

        List<Transaction> transactions = getAllTransactions();

        boolean exists = transactions.stream()
                .anyMatch(existing -> existing.getId() == transaction.getId());

        if (!exists) {
            return "ERROR: Transaction not found.";
        }

        transaction.setDescription(description);

        transactionDao.update(transaction);

        return "SUCCESS: Transaction updated successfully.";
    }

    public String deleteTransaction(int id) {

        boolean exists = getAllTransactions()
                .stream()
                .anyMatch(existing -> existing.getId() == id);

        if (!exists) {
            return "ERROR: Transaction not found.";
        }

        transactionDao.delete(id);

        return "SUCCESS: Transaction deleted successfully.";
    }
}