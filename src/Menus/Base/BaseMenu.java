package Menus.Base;

import Menus.Entities.AccountMenu;
import Menus.Entities.CategoryMenu;
import Menus.Entities.TransactionMenu;

import java.util.Scanner;

public class BaseMenu {

    private final CategoryMenu categoryMenu;
    private final TransactionMenu transactionMenu;
    private final AccountMenu accountMenu;

    public BaseMenu(CategoryMenu categoryMenu, TransactionMenu transactionMenu, AccountMenu accountMenu) {
        this.categoryMenu = categoryMenu;
        this.transactionMenu = transactionMenu;
        this.accountMenu = accountMenu;
    }

    public void showMenu() {

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                                                ║");
        System.out.println("║                FINANCE MANAGER                 ║");
        System.out.println("║                                                ║");
        System.out.println("║  Welcome to your financial management system!  ║");
        System.out.println("║                                                ║");
        System.out.println("║                      2026                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        resolveMenuOptions();
    }

    public void resolveMenuOptions() {

        Scanner input = new Scanner(System.in);
        int option;

        do {

            System.out.println();
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║              SELECT AN OPTION                  ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║  1. Manage Categories                          ║");
            System.out.println("║  2. Manage Accounts                            ║");
            System.out.println("║  3. Manage Transactions                        ║");
            System.out.println("║  4. Manage Goals                               ║");
            System.out.println("║  0. Exit                                       ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");

            option = input.nextInt();

            navigate(option);

        } while (option != 0);
    }

    public void navigate(int option) {

        switch (option) {
            case 1:
                categoryMenu.showMenu();
                break;
            case 2:
                accountMenu.showMenu();
                break;
            case 3:
                transactionMenu.showMenu();
            default:
                break;

        }
    }
}
