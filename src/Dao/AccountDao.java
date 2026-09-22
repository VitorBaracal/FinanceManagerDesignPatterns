package Dao;

import Entities.Account;
import Interfaces.BaseAccountDao;

import java.util.ArrayList;
import java.util.List;

public class AccountDao implements BaseAccountDao {

    private final List<Account> accounts = new ArrayList<>();
    private int id = 1;

    @Override
    public void save(Account account) {
        account.setId(id++);
        accounts.add(account);
    }

    @Override
    public List<Account> getAllAccounts(){return accounts;}

    @Override
    public void update(int id, int newAgency) {
        for(Account account : accounts) {
            if (account.getId() == id) {
                account.setAgency(newAgency);
                return;
            }
        }
    }

    @Override
    public void update(int id, String newBankName){
        for (Account account : accounts){
            if (account.getId() == id){
                account.setBankName(newBankName);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {accounts.removeIf(account -> account.getId() == id);
    }
}
