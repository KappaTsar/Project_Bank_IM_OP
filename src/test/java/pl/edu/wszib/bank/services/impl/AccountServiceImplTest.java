package pl.edu.wszib.bank.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.bank.configuration.AppConfigTest;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.services.IAccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@WebAppConfiguration
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