package Strategies;

import Services.AccountService;

public interface BalanceStrategy {

    void apply(AccountService accountService, int accountId, double amount);
}
