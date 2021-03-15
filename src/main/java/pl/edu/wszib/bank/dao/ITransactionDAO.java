package pl.edu.wszib.bank.dao;

import pl.edu.wszib.bank.model.TransactionDetails;

public interface ITransactionDAO{
    boolean saveTrans(TransactionDetails transaction);
}
