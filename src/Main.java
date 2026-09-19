import Controllers.CategoryController;
import Controllers.TransactionController;
import Dao.CategoryDao;
import Dao.TransactionDao;
import Menus.Base.BaseMenu;
import Menus.Entities.CategoryMenu;
import Menus.Entities.TransactionMenu;
import Services.CategoryService;
import Services.TransactionService;

public class Main {

    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();
        CategoryService categoryService = new CategoryService(categoryDao);
        CategoryController categoryController = new CategoryController(categoryService);
        CategoryMenu categoryMenu = new CategoryMenu(categoryController);
        TransactionDao transactionDao = new TransactionDao();
        TransactionService transactionService = new TransactionService(transactionDao);
        TransactionController transactionController = new TransactionController(transactionService, categoryController);
        TransactionMenu transactionMenu= new TransactionMenu(transactionController);

        BaseMenu baseMenu = new BaseMenu(categoryMenu, transactionMenu);
        baseMenu.showMenu();
    }
}
