package Strategies;

import Services.AccountService;

public class IncreaseBalanceStrategy implements BalanceStrategy {

    @Override
    public void apply(AccountService accountService, int accountId, double amount) {

        accountService.increaseBalance(accountId, amount);

    }
}
