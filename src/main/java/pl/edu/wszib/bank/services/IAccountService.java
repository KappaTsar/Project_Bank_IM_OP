package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.Account;

public interface IAccountService {
    void deposit(Account curAcc, Double amountIn);
    void withdraw(Account curAcc, Double amountOut);
    void crossAccTransfer(String title, String accountNumTo, Account curAcc, Double amount);
    Account getAccountById(int id);
}
