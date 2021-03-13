package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.services.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public void deposit(Double amountIn, Account curAcc) {
        Account getAccountFromDB = this.accountDAO.getAccountByID(curAcc.getId());
        getAccountFromDB.setBalance(curAcc.getBalance() + amountIn);
        this.accountDAO.updateAccount(getAccountFromDB);
    }

    @Override
    public void withdraw(Double amountOut, Account curAcc) {
        Account getAccountFromDB = this.accountDAO.getAccountByID(curAcc.getId());
        getAccountFromDB.setBalance(curAcc.getBalance() - amountOut);
        this.accountDAO.updateAccount(getAccountFromDB);
    }

    @Override
    public void makeTransaction(Double amount, String accountNumFrom, String accountNumTo) {
        Account getAccountFromDB = this.accountDAO.getAccountByNUM(accountNumFrom);
        getAccountFromDB.setBalance(getAccountFromDB.getBalance() - amount);
        this.accountDAO.updateAccount(getAccountFromDB);

        Account get2AccountFromDB = this.accountDAO.getAccountByNUM(accountNumTo);
        get2AccountFromDB.setBalance(get2AccountFromDB.getBalance() + amount);
        this.accountDAO.updateAccount(get2AccountFromDB);
    }

    @Override
    public Account getAccountById(int id) {
        return this.accountDAO.getAccountByID(id);
    }
}
