package Controllers;

import Entities.Account;
import Services.AccountService;

import java.util.List;
import java.util.Scanner;


public class AccountController {

    private final AccountService service;
    private final Scanner input = new Scanner(System.in);

    public AccountController(AccountService service) {
        this.service = service;
    }

    public void getAccount(){
        List<Account> accounts = service.getAllAccounts();

        if (accounts.isEmpty()){
            System.out.println("ERROR: No accounts found.");
            return;
        }
        System.out.println("SUCCESS: Accounts listed successfully.");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void postAccount(){
        System.out.print("Enter Bank name: ");
        String bankname = input.nextLine();

        System.out.print("Enter Agency Number: ");
        int agency = input.nextInt();
        input.nextLine();

        double balance = getBalance();

        Account account = new Account(0, bankname, agency, balance);
        String result = service.addAccount(account);
        System.out.println(result);
    }

    private double getBalance(){
         while (true) {
             System.out.print("Enter your currently Balance: ");
             String text = input.nextLine();

            try {
                double balance = Double.parseDouble(text);
                return balance;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Please insert a valid Balance");
            }

         }
    }

    public void updateAccount(){

        System.out.print("Enter Account ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("Leave Bank name blank to keep the current value.");
        System.out.print("Enter new Bank name: ");
        String bankname = input.nextLine();

        System.out.println("Enter 0 to keep the current Agency Number.");
        System.out.print("Enter new Agency Number: ");
        input.nextLine();
        int agency = input.nextInt();

        Account account = new Account(id, bankname, agency, 0); // balance is ignored by updateAccount
        String result = service.updateAccount(account);
        System.out.println(result);

    }

    public void deleteAccount(){

        System.out.print("Enter Account ID: ");
        int id = input.nextInt();
        input.nextLine();

        String result = service.deleteAccount(id);
        System.out.println(result);
    }
}
