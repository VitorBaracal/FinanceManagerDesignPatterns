package Dao;

import Entities.Category;
import Interfaces.BaseCategoryDao;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements BaseCategoryDao {

    private final List<Category> categories = new ArrayList<>();

    @Override
    public void save(Category category) {

    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void update(int id, String newName) {

    }

    @Override
    public void delete(int id) {

    }
}
