package Controllers;

import Entities.Category;
import Entities.Transaction.Expense;
import Entities.Transaction.Income;
import Entities.Transaction.Transaction;
import Factories.TransactionFactory;
import Services.TransactionService;

import java.util.List;
import java.util.Scanner;

public class TransactionController {

    private final TransactionService service;
    private final CategoryController categoryController;
    private final Scanner input = new Scanner(System.in);

    public TransactionController(
            TransactionService service,
            CategoryController categoryController
    ) {
        this.service = service;
        this.categoryController = categoryController;
    }

    public void getTransaction() {

        List<Transaction> transactionsList = service.getAllTransactions();

        if (transactionsList.isEmpty()) {
            System.out.println("ERROR: No transactions found.");
            return;
        }

        System.out.println("SUCCESS: Transactions listed successfully.");

        for (Transaction transaction : transactionsList) {
            System.out.println(transaction);
        }
    }

    public void postTransaction() {

        Transaction transaction = createTransaction(0);

        if (transaction == null) {
            return;
        }

        String result = service.addTransaction(transaction);
        System.out.println(result);
    }

    public void updateTransaction() {

        System.out.print("Enter transaction ID: ");
        int id = input.nextInt();
        input.nextLine();

        Transaction transaction = createTransaction(id);

        if (transaction == null) {
            return;
        }

        String result = service.updateTransaction(transaction);
        System.out.println(result);
    }

    public void deleteTransaction() {

        System.out.print("Enter transaction ID: ");
        int id = input.nextInt();
        input.nextLine();

        String result = service.deleteTransaction(id);
        System.out.println(result);
    }

    private Transaction createTransaction(int id) {

        int type = getTransactionType();

        if (type == -1) {
            return null;
        }

        String description = getDescription();

        double amount = getAmount();

        String date = getDate();

        Category category = categoryController.selectCategory();

        if (category == null) {
            return null;
        }

        return TransactionFactory.create(
                type,
                id,
                description,
                amount,
                date,
                category
        );
    }

    private int getTransactionType() {
        System.out.println("Select transaction type:");
        System.out.println("1. Income");
        System.out.println("2. Expense");
        System.out.print("Enter your choice: ");

        int type = input.nextInt();
        input.nextLine();

        if (type != 1 && type != 2) {
            System.out.println("ERROR: Invalid transaction type.");
            return -1;
        }

        return type;
    }

    private String getDescription() {
        System.out.print("Enter transaction description: ");
        return input.nextLine();
    }

    private double getAmount() {
        System.out.print("Enter transaction amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        return amount;
    }

    private String getDate() {
        System.out.print("Enter transaction date: ");
        return input.nextLine();
    }
}