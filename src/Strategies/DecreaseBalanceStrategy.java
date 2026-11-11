package Strategies;

import Services.AccountService;

public class DecreaseBalanceStrategy implements BalanceStrategy {

    @Override
    public void apply(AccountService accountService, int accountId, double amount) {

        accountService.decreaseBalance(accountId, amount);

    }
}
