package Menus.Entities;

import Controllers.TransactionController;

import java.util.Scanner;

public class TransactionMenu {
    private final Scanner input = new Scanner(System.in);
    private final TransactionController controller;

    public TransactionMenu(TransactionController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              TRANSACTION MANAGEMENT            ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. Create Transaction                         ║");
        System.out.println("║  2. List Transactions                          ║");
        System.out.println("║  3. Update Transaction                         ║");
        System.out.println("║  4. Delete Transaction                         ║");
        System.out.println("║  0. Back to Main Menu                          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        resolveTransactionOptions();
    }

    public void resolveTransactionOptions() {
        int option = input.nextInt();
        input.nextLine();
        navigate(option);
    }

    public void navigate(int option) {
        switch (option) {
            case 1:
                controller.postTransaction();
                showMenu();
                break;
            case 2:
                controller.getTransaction();
                showMenu();
                break;
            case 3:
                controller.updateTransaction();
                showMenu();
                break;
            case 4:
                controller.deleteTransaction();
                showMenu();
                break;
            case 0:
                break;
        }
    }
}
