package pl.edu.wszib.bank.services.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.bank.configuration.AppConfigTest;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.AccCreationModel;
import pl.edu.wszib.bank.model.view.NewPassModel;
import pl.edu.wszib.bank.model.view.RegistrationModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;

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
        User curUser = new User(2, "foldinbrag", "foldin123", User.Role.USER);
        NewPassModel newPassModel = new NewPassModel();
        newPassModel.setOld_pass("foldin123");
        newPassModel.setNew_pass("ghFr123");
        newPassModel.setNew_pass2("ghFr123");

        boolean result = userService.changePass(curUser, newPassModel);
        Assert.assertTrue(result);
    }

    @Test
    void newUser() {
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("foldinbrag");
        registrationModel.setPass("foldin123");
        registrationModel.setPass2("foldin123");

        boolean result = userService.newUser(registrationModel);
        Assert.assertTrue(result);
    }

    @Test
    void makeAccount() {

        //AccCreationModel accCreationModel = new AccCreationModel();
        //accCreationModel.setChosenLogin("foldinbrag");

        User chosUser = new User(2, "foldinbrag", "foldin123", User.Role.USER);//this.userDAO.getUserByLogin(accCreationModel.getChosenLogin());

        boolean result = this.userService.makeAccount(chosUser);

        Assert.assertTrue(result);
    }
}