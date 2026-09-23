import Controllers.AccountController;
import Controllers.CategoryController;
import Controllers.TransactionController;
import Dao.AccountDao;
import Dao.CategoryDao;
import Dao.TransactionDao;
import Menus.Base.BaseMenu;
import Menus.Entities.AccountMenu;
import Menus.Entities.CategoryMenu;
import Menus.Entities.TransactionMenu;
import Services.AccountService;
import Services.CategoryService;
import Services.TransactionService;

public class Main {

    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        AccountService accountService = new AccountService(accountDao);
        AccountController accountController = new AccountController(accountService);
        AccountMenu accountMenu = new AccountMenu(accountController);
        CategoryDao categoryDao = new CategoryDao();
        CategoryService categoryService = new CategoryService(categoryDao);
        CategoryController categoryController = new CategoryController(categoryService);
        CategoryMenu categoryMenu = new CategoryMenu(categoryController);
        TransactionDao transactionDao = new TransactionDao();
        TransactionService transactionService = new TransactionService(transactionDao, accountService);
        TransactionController transactionController = new TransactionController(transactionService, categoryController, accountController);
        TransactionMenu transactionMenu= new TransactionMenu(transactionController);

        BaseMenu baseMenu = new BaseMenu(categoryMenu, transactionMenu, accountMenu);
        baseMenu.showMenu();
    }
}
