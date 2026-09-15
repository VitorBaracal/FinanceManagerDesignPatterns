package Menus.Entities;

import java.util.Scanner;

public class CategoryMenu {

    public static void showMenu() {

        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              CATEGORY MANAGEMENT               ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. Create Category                            ║");
        System.out.println("║  2. List Categories                            ║");
        System.out.println("║  3. Update Category                            ║");
        System.out.println("║  4. Delete Category                            ║");
        System.out.println("║  0. Back to Main Menu                          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        CategoryMenu.resolveCategoryOptions();
    }

    public static void resolveCategoryOptions() {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        navigate(option);
    }

    public static void navigate(int option) {

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
        }
    }
}
