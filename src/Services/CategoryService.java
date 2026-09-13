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

    public void addCategory(Category category) {

    }

    public void updateCategory(Category category) {

    }

    public void deleteCategory(int id) {

    }
}
