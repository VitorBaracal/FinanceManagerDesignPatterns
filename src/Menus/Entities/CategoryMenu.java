package Menus.Entities;

import Controllers.CategoryController;

import java.util.Scanner;

public class CategoryMenu {

    private final CategoryController controller;
    private final Scanner input = new Scanner(System.in);

    public CategoryMenu(CategoryController controller) {
        this.controller = controller;
    }

    public void showMenu() {
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

        resolveCategoryOptions();
    }

    public void resolveCategoryOptions() {
        int option = input.nextInt();
        input.nextLine();
        navigate(option);
    }

    public void navigate(int option) {
        switch (option) {
            case 1:
                controller.postCategory();
                showMenu();
                break;
            case 2:
                controller.getCategory();
                showMenu();
                break;
            case 3:
                controller.updateCategory();
                showMenu();
                break;
            case 4:
                controller.deleteCategory();
                showMenu();
                break;
            case 0:
                break;
        }
    }
}
