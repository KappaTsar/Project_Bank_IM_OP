package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.RegistrationModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    SessionObject sessionObject;


    @Qualifier("IUserDAO")
    @Autowired
    IUserDAO userDAO;

    @Qualifier("IAccountDAO")
    @Autowired
    IAccountDAO accountDAO;

    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.findUserByLogin(user.getLogin());
        if(userFromDatabase == null) {
            return;
        }

        if(user.getPass().equals(userFromDatabase.getPass())) {
            this.sessionObject.setLoggedUser(userFromDatabase);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public void changePass(User user) {
        User getUserFromDB = this.userDAO.findUserById(user.getId());
        getUserFromDB.setPass(user.getPass());
        this.userDAO.save(getUserFromDB);
    }

    @Override
    public boolean newUser(RegistrationModel registrationModel) {
        if(this.userDAO.findUserByLogin(registrationModel.getLogin()) != null) {
            return false;
        }

        User newUser = new User(0, registrationModel.getLogin(), registrationModel.getPass(), User.Role.USER);

        try {
            this.userDAO.save(newUser);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean makeAccount(User chosenUser) {
        if(this.userDAO.findUserByLogin(chosenUser.getLogin()) == null) {
            return false;
        }

        Account newAcc = new Account(0, chosenUser);
        chosenUser.addnewAcctoList(newAcc);

        try {
            this.accountDAO.save(newAcc);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(int id) {
        return this.userDAO.findUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return this.userDAO.findUserByLogin(login);
    }
}
