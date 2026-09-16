import Controllers.CategoryController;
import Dao.CategoryDao;
import Menus.Base.BaseMenu;
import Menus.Entities.CategoryMenu;
import Services.CategoryService;

public class Main {

    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();
        CategoryService categoryService = new CategoryService(categoryDao);
        CategoryController categoryController = new CategoryController(categoryService);
        CategoryMenu categoryMenu = new CategoryMenu(categoryController);

        BaseMenu baseMenu = new BaseMenu(categoryMenu);
        baseMenu.showMenu();
    }
}
