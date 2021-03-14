package pl.edu.wszib.bank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.dao.impl.AccountDAOStub;
import pl.edu.wszib.bank.dao.impl.TransactionDAOStub;
import pl.edu.wszib.bank.dao.impl.UserDAOStub;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.bank.session",
        "pl.edu.wszib.bank.controllers",
        "pl.edu.wszib.bank.services.impl"})
public class AppConfigTest {
    @Bean
    public IAccountDAO accountDAO(){
        return new AccountDAOStub();
    }
    @Bean
    public IUserDAO userDAO(){
        return new UserDAOStub();
    }
    @Bean
    public ITransactionDAO transactionDAO(){
        return new TransactionDAOStub();
    }
}