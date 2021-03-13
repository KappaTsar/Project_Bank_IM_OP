package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.Account;

public interface IAccountService {
    void deposit(Double amountIn, Account curAcc);
    void withdraw(Double amountOut, Account curAcc);
    void makeTransaction(Double amount, String accountNumFrom, String accountNumTo);
    Account getAccountById(int id);
}
