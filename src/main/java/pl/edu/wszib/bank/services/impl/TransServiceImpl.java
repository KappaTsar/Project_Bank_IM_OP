package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.TransactionDetails;
import pl.edu.wszib.bank.services.ITransService;

public class TransServiceImpl implements ITransService {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public void saveTransaction(TransactionDetails transDis) {

    }

    @Override
    public TransactionDetails getTransById(int id) {
        return null;
    }
}
