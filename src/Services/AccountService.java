package Services;

import Entities.Account;
import Interfaces.BaseAccountDao;

import java.util.List;

    public class AccountService {

        private final BaseAccountDao accountDao;

        public void increaseBalance(int accountId, double amount) {
            List<Account> accounts = getAllAccounts();
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    account.setBalance(account.getBalance() + amount);
                    return;
                }
            }
        }

        public void decreaseBalance(int accountId, double amount) {
            List<Account> accounts = getAllAccounts();
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    account.setBalance(account.getBalance() - amount);
                    return;
                }
            }
        }

        public AccountService(BaseAccountDao accountDao) {
            this.accountDao = accountDao;
        }

        public List<Account> getAllAccounts() {
            return accountDao.getAllAccounts();
        }

        public String addAccount(Account account){
            if (account.getBankName() == null) {
                return "ERROR: Bank Name cannot be empty.";
            }

            if (account.getAgency() == 0) {
                return "ERROR: Agency Number cannot be null";
            }

            List<Account> accounts = getAllAccounts();
            for (Account existing : accounts){
                if (account.getAgency() == existing.getAgency()){
                    return "ERROR: Agency Number already exists";
                }
            }

            int agency = account.getAgency();
            double balance = account.getBalance();
            String bankName = account.getBankName().trim();
            account.setBankName(bankName);

            accountDao.save(account);
            return "SUCCESS: Account with Bank Name '" + bankName + "' with Agency Number '" + agency +
                    "' and Balance '" + balance + "' created successfully.";
        }

        public String updateAccount(Account account){
            List<Account> accounts = getAllAccounts();
            boolean exists = accounts.stream().anyMatch(existing -> existing.getId() == account.getId());
            boolean changed = false;

            if (!exists) {
                return "ERROR: Account not found.";
            }

            if(account.getBankName() != null && ! account.getBankName().isBlank()){
                accountDao.update(account.getId(), account.getBankName());
                changed = true;
            }

            if (account.getAgency() != 0){
                accountDao.update(account.getId(), account.getAgency());
                changed = true;
            }

            if (!changed){
                return "ERROR: No changes were made.";
            }
            return "SUCCESS: Account updated successfully.";
        }

        public String deleteAccount(int id) {

            boolean exists = getAllAccounts().stream().anyMatch(existing -> existing.getId() == id);

            if (!exists) {
                return "ERROR: Account not found.";
            }

            accountDao.delete(id);
            return "SUCCESS: Account deleted successfully.";
        }
    }