package Interfaces;

import Entities.Account;

import java.util.List;

public interface BaseAccountDao {

    public void save(Account account);

    public List<Account> getAllAccounts();

    public void update (int id, int newAgency);

    public void update (int id, String newBankName);

    public void delete(int id);
}