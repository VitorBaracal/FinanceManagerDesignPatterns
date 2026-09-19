package Entities.Transaction;

import Entities.Category;

public abstract class Transaction {

    private int id;
    private String description;
    private double amount;
    private String date;
    private Category category;

    public Transaction(
            int id,
            String description,
            double amount,
            String date,
            Category category
    ) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Description: " + description +
                " | Amount: " + amount +
                " | Date: " + date +
                " | Category: " + category;
    }
}
