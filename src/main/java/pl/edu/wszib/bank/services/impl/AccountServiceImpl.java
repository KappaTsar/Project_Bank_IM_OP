package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.services.IAccountService;
import pl.edu.wszib.bank.services.ITransService;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    ITransService transService;

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public void deposit(Account curAcc, Double amountIn) {
        Account getAccountFromDB = this.accountDAO.findAccountById(curAcc.getId());
        getAccountFromDB.setBalance(curAcc.getBalance() + amountIn);
        this.transService.makeTransaction("Deposit", getAccountFromDB, amountIn);
        this.accountDAO.save(getAccountFromDB);
    }

    @Override
    public void withdraw(Account curAcc, Double amountOut) {
        Account getAccountFromDB = this.accountDAO.findAccountById(curAcc.getId());
        getAccountFromDB.setBalance(curAcc.getBalance() - amountOut);
        this.transService.makeTransaction("Withdraw", getAccountFromDB, -amountOut);
        this.accountDAO.save(getAccountFromDB);
    }

    @Override
    public void crossAccTransfer(String title, String accountNumTo, Account curAcc, Double amount) {
        Account getAccountFromDB = this.accountDAO.findAccountById(curAcc.getId());
        getAccountFromDB.setBalance(getAccountFromDB.getBalance() - amount);
        this.transService.makeTransaction(title, curAcc, -amount);
        this.accountDAO.save(getAccountFromDB);

        Account get2AccountFromDB = this.accountDAO.findAccountByAccNumber(accountNumTo);
        get2AccountFromDB.setBalance(get2AccountFromDB.getBalance() + amount);
        this.transService.makeTransaction(title, get2AccountFromDB, amount);
        this.accountDAO.save(get2AccountFromDB);
    }

    @Override
    public Account getAccountById(int id) {
        return this.accountDAO.findAccountById(id);
    }
}
