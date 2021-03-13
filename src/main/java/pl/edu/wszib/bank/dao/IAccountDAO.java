package pl.edu.wszib.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.bank.model.Account;

public interface IAccountDAO extends JpaRepository<Account, Integer> {
    Account findAccountByAccNumber(String accountNumTo);
    Account findAccountById(int id);
}