package pl.edu.wszib.bank.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.services.IAccountService;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    @Autowired
    IAccountDAO accountDAO;

    @Autowired
    IAccountService accountService;

    @Test
    void deposit() {
    }

    @Test
    void withdraw() {
    }

    @Test
    void crossAccTransfer() {
    }


}