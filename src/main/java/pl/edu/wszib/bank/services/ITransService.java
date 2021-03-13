package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.TransactionDetails;

public interface ITransService {
    void saveTransaction(TransactionDetails transDis);
    TransactionDetails getTransById(int id);
}
