package Services;

import Dao.TransactionDao;
import Entities.Transaction.Income;
import Entities.Transaction.Transaction;
import Observers.PrintTransactionObserver;
import Observers.TransactionObserver;
import Strategies.BalanceStrategy;
import Strategies.DecreaseBalanceStrategy;
import Strategies.IncreaseBalanceStrategy;

import java.util.List;

public class TransactionService {

    private final TransactionDao transactionDao;
    private final AccountService accountService;
    private final TransactionObserver observer = new PrintTransactionObserver();

    public TransactionService(TransactionDao transactionDao, AccountService accountService) {
        this.transactionDao = transactionDao;
        this.accountService = accountService;
    }

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

        BalanceStrategy strategy;

        if (transaction instanceof Income) {
            strategy = new IncreaseBalanceStrategy();
        } else {
            strategy = new DecreaseBalanceStrategy();
        }

        strategy.apply(accountService, transaction.getAccountId(), transaction.getAmount());

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
        observer.onTransactionUpdated(transaction);

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
