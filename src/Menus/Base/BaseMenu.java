package Menus.Base;

import Menus.Entities.CategoryMenu;

import java.util.Scanner;

public class BaseMenu {

    public void showMenu(){

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

        int option = input.nextInt();
        navigate(option);
    }

    public void navigate(int option) {

        switch (option) {
            case 1:
                CategoryMenu.showMenu();
                break;
            default:
                break;

        }
    }
}
