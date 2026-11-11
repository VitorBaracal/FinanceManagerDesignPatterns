package Entities.Transaction;

import Entities.Category;

public class Income extends Transaction {

    public Income(int id, String description, double amount, String date, Category category, int accountId) {
        super(id, description, amount, date, category, accountId);
    }
}
