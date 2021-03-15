package pl.edu.wszib.bank.dao.impl;

import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import java.util.List;

public class AccountDAOStub implements IAccountDAO {
    @Override
    public void updateAccount(Account account) {
    }

    @Override
    public Account getAccountByNUM(String NUM) {
        return null;
    }

    @Override
    public Account getAccountByID(int id) {
        return null;
    }

    @Override
    public boolean persistAccount(Account account) {
        return true;
    }

    @Override
    public List<Account> showAccountList(User user) {
        return null;
    }
}
