package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import java.util.List;

public interface IAccountService {
    void deposit(Account curAcc, Double amountIn);
    void withdraw(Account curAcc, Double amountOut);
    void crossAccTransfer(String title, String accountNumTo, Account curAcc, Double amount);
    List<Account> viewAccounts(User curUser);
    Account getAccountById(int id);
}
