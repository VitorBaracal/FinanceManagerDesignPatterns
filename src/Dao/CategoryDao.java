package Dao;

import Entities.Category;
import Interfaces.BaseCategoryDao;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements BaseCategoryDao {

    private final List<Category> categories = new ArrayList<>();
    private int id = 1;

    @Override
    public void save(Category category) {
        category.setId(id++);
        categories.add(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void update(int id, String newName) {
        for (Category category : categories) {
            if (category.getId() == id) {
                category.setName(newName);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        categories.removeIf(category -> category.getId() == id);
    }
}
