package pl.edu.wszib.bank.dao.impl;

import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.model.TransactionDetails;

public class TransactionDAOStub implements ITransactionDAO {
    @Override
    public boolean saveTrans(TransactionDetails transaction) {
        return true;
    }
}
