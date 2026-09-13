package Controllers;

import Entities.Category;
import Services.CategoryService;

import java.util.List;

public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    public List<Category> getCategory() {
        return service.getAllCategories();
    }

    public void postCategory(Category category) {
        service.addCategory(category);
    }

    public void updateCategory(Category category) {
        service.updateCategory(category);
    }

    public void deleteCategory(int id) {
        service.deleteCategory(id);
    }
}
