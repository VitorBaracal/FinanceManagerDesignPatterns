package Menus.Entities;

import Controllers.AccountController;

import java.util.Scanner;

public class AccountMenu {

    private final AccountController controller;
    private final Scanner input = new Scanner(System.in);

    public AccountMenu(AccountController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              ACCOUNT MANAGEMENT                ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. Create Account                             ║");
        System.out.println("║  2. List Accounts                              ║");
        System.out.println("║  3. Update Account                             ║");
        System.out.println("║  4. Delete Account                             ║");
        System.out.println("║  0. Back to Main Menu                          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        resolveAccountOptions();
    }

    public void resolveAccountOptions() {
        int option = input.nextInt();
        input.nextLine();
        navigate(option);
    }

    public void navigate(int option) {
        switch (option) {
            case 1:
                controller.postAccount();
                showMenu();
                break;
            case 2:
                controller.getAccount();
                showMenu();
                break;
            case 3:
                controller.updateAccount();
                showMenu();
                break;
            case 4:
                controller.deleteAccount();
                showMenu();
                break;
            case 0:
                break;
        }
    }
}