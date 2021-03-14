package pl.edu.wszib.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import java.util.List;

public interface IAccountDAO extends JpaRepository<Account, Integer> {
    Account findAccountByAccNumber(String accountNumTo);
    Account findAccountById(int id);
    List<Account> findAccountsByUserID(User user);
}