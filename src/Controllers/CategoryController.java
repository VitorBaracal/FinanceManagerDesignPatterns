package Controllers;

import Entities.Category;
import Services.CategoryService;

import java.util.List;
import java.util.Scanner;

public class CategoryController {

    private final CategoryService service;
    private final Scanner input = new Scanner(System.in);

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    public void getCategory() {
        List<Category> categories = service.getAllCategories();

        if (categories.isEmpty()) {
            System.out.println("ERROR: No categories found.");
            return;
        }

        System.out.println("SUCCESS: Categories listed successfully.");
        for (Category category : categories) {
            System.out.println("ID: " + category.getId() + " | Name: " + category.getName());
        }
    }

    public void postCategory() {
        System.out.println("Enter category name: ");
        String name = input.nextLine();

        Category category = new Category(0, name);
        String result = service.addCategory(category);
        System.out.println(result);
    }

    public void updateCategory() {
        System.out.print("Enter category ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter new category name: ");
        String name = input.nextLine();

        Category category = new Category(id, name);
        String result = service.updateCategory(category);
        System.out.println(result);
    }

    public void deleteCategory() {
        System.out.print("Enter category ID: ");
        int id = input.nextInt();
        input.nextLine();

        String result = service.deleteCategory(id);
        System.out.println(result);
    }

    public Category selectCategory() {

        List<Category> categories = service.getAllCategories();

        if (categories.isEmpty()) {
            System.out.println("ERROR: No categories found.");
            return null;
        }

        System.out.println();
        System.out.println("Available categories:");

        for (Category category : categories) {
            System.out.println(
                    "ID: " + category.getId()
                            + " | Name: " + category.getName()
            );
        }

        System.out.print("Enter category ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }

        System.out.println("ERROR: Category not found.");
        return null;
    }
}
