package Interfaces;

import Entities.Category;

import java.util.List;

public interface BaseCategoryDao {

    public void save(Category category);

    public List<Category> getAllCategories();

    public void update(int id, String newName);

    public void delete(int id);
}