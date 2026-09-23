package Factories;

import Entities.Category;
import Entities.Transaction.Expense;
import Entities.Transaction.Income;
import Entities.Transaction.Transaction;

public class TransactionFactory {

    public static Transaction create(
            int type,
            int id,
            String description,
            double amount,
            String date,
            Category category,
            int accountId
    ) {

        if (type == 1) {
            return new Income(
                    id,
                    description,
                    amount,
                    date,
                    category,
                    accountId
            );
        }

        if (type == 2) {
            return new Expense(
                    id,
                    description,
                    amount,
                    date,
                    category,
                    accountId
            );
        }

        return null;
    }
}