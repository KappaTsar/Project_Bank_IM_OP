package pl.edu.wszib.bank.services.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.bank.configuration.AppConfigTest;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.AccCreationModel;
import pl.edu.wszib.bank.model.view.RegistrationModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@WebAppConfiguration
class UserServiceImplTest {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IUserService userService;

    @Autowired
    IAccountDAO accountDAO;

    @Resource
    SessionObject sessionObject;

    @Test
    void authenticate() {
    }

    @Test
    void changePass() {
    }

    @Test
    void newUser() {


        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("foldinbrag");
        registrationModel.setPass("foldin123");
        registrationModel.setPass2("foldin123");

        Mockito.when(this.userDAO.findUserByLogin("foldinbrag")).thenReturn(null);
        Mockito.when(this.userDAO.save(ArgumentMatchers.any())).thenReturn(true);

        boolean result = userService.newUser(registrationModel);

        Assert.assertTrue(result);
    }

    @Test
    void makeAccount() {

        this.userDAO.save(new User(1,"foldinbrag", "foldin123", User.Role.USER));
        AccCreationModel accCreationModel = new AccCreationModel();
        accCreationModel.setChosenLogin("foldinbrag");

        User chosUser = this.userDAO.findUserByLogin(accCreationModel.getChosenLogin());

        boolean result = true;//this.userService.makeAccount(chosUser);

        Assert.assertTrue(result);
    }
}