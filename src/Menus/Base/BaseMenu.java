package Menus.Base;

import Menus.Entities.AccountMenu;
import Menus.Entities.CategoryMenu;
import Menus.Entities.PaymentMenu;
import Menus.Entities.TransactionMenu;

import java.util.Scanner;

public class BaseMenu {

    private final CategoryMenu categoryMenu;
    private final TransactionMenu transactionMenu;
    private final AccountMenu accountMenu;
    private final PaymentMenu paymentMenu;

    public BaseMenu(CategoryMenu categoryMenu, TransactionMenu transactionMenu, AccountMenu accountMenu, PaymentMenu paymentMenu) {
        this.categoryMenu = categoryMenu;
        this.transactionMenu = transactionMenu;
        this.accountMenu = accountMenu;
        this.paymentMenu = paymentMenu;
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
            System.out.println("║  4. Payment                                    ║");
            System.out.println("║  0. Exit                                       ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");

            option = input.nextInt();
            input.nextLine();

            if (option == 0 && !confirmExit(input)) {
                continue;
            }

            navigate(option);

        } while (option != 0);

    }

    private boolean confirmExit(Scanner input) {

        System.out.println("Do you want to exit? The data will be lost.");
        System.out.print("Enter Y to exit or N to stay: ");
        String answer = input.nextLine();
        return answer.equalsIgnoreCase("Y");

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
                break;
            case 4:
                paymentMenu.showMenu();
                break;
            default:
                break;

        }

    }
}
