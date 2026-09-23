package Entities;

public class Account {

    private int id;
    private String bankName;
    private int agency;
    private double balance;

    public Account(int id, String bankName, int agency, double balance) {
        this.id = id;
        this.bankName = bankName;
        this.agency = agency;
        this.balance = balance;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getBankName(){return bankName;}

    public void setBankName(String bankName){this.bankName = bankName;}

    public int getAgency() {return agency;}

    public void setAgency(int agency){this.agency = agency; }

    public double getBalance() {return balance;}

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Bank: " + bankName +
                " | Agency: " + agency +
                " | Balance: " + balance;
    }

}
