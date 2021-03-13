package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.TransactionDetails;
import pl.edu.wszib.bank.services.ITransService;

@Service
public class TransServiceImpl implements ITransService {

    @Autowired
    ITransactionDAO transactionDAO;

    @Override
    public void makeTransaction(String title, Account account, Double transAmount) {
        TransactionDetails transaction = new TransactionDetails(0, title, account, transAmount);
        account.addnewTransactionToHistory(transaction);
        this.transactionDAO.save(transaction);
    }

    @Override
    public TransactionDetails getTransById(int id) {
        return this.transactionDAO.findTransactionDetailsById(id);
    }
}
