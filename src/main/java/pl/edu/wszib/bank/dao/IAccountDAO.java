package pl.edu.wszib.bank.dao;

import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import java.util.List;

public interface IAccountDAO{
    void updateAccount(Account account);
    Account getAccountByNUM(String NUM);
    Account getAccountByID(int id);
    boolean persistAccount(Account account);
    List<Account> showAccountList(User user);
}