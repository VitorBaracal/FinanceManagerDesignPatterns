import Controllers.AccountController;
import Controllers.CategoryController;
import Controllers.PaymentController;
import Controllers.TransactionController;
import Dao.AccountDao;
import Dao.CategoryDao;
import Dao.TransactionDao;
import Menus.Base.BaseMenu;
import Menus.Entities.AccountMenu;
import Menus.Entities.CategoryMenu;
import Menus.Entities.PaymentMenu;
import Menus.Entities.TransactionMenu;
import Services.AccountService;
import Services.CategoryService;
import Services.PaymentService;
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
        PaymentService paymentService = new PaymentService();
        PaymentController paymentController = new PaymentController(paymentService);
        PaymentMenu paymentMenu = new PaymentMenu(paymentController);

        BaseMenu baseMenu = new BaseMenu(categoryMenu, transactionMenu, accountMenu, paymentMenu);
        baseMenu.showMenu();

    }
}
