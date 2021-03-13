package pl.edu.wszib.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.bank.model.TransactionDetails;

public interface ITransactionDAO extends JpaRepository<TransactionDetails, Integer> {
    TransactionDetails findTransactionDetailsById(int id);
}
