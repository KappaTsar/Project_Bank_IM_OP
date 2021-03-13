package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.TransactionDetails;

public interface ITransService {
    void makeTransaction(String title, Account account, Double transAmount);
    TransactionDetails getTransById(int id);
}
