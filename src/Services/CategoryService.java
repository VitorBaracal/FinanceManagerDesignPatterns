package Services;

import Entities.Category;
import Interfaces.BaseCategoryDao;

import java.util.List;

public class CategoryService {

    private final BaseCategoryDao categoryDao;

    public CategoryService(BaseCategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public String addCategory(Category category) {

        if (category.getName() == null) {
            return "ERROR: Category name cannot be empty.";
        }

        String name = category.getName().trim();
        category.setName(name);
        categoryDao.save(category);
        return "SUCCESS: Category '" + name + "' created successfully.";
    }

    public String updateCategory(Category category) {

        if (category.getName() == null ) {
            return "ERROR: Category name cannot be empty.";
        }

        String name = category.getName().trim();
        List<Category> categories = getAllCategories();
        boolean exists = categories.stream().anyMatch(existing -> existing.getId() == category.getId());

        if (!exists) {
            return "ERROR: Category not found.";
        }

        categoryDao.update(category.getId(), name);
        return "SUCCESS: Category updated successfully.";
    }

    public String deleteCategory(int id) {

        boolean exists = getAllCategories().stream().anyMatch(existing -> existing.getId() == id);

        if (!exists) {
            return "ERROR: Category not found.";
        }

        categoryDao.delete(id);
        return "SUCCESS: Category deleted successfully.";
    }
}
