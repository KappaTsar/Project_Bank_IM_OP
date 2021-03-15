package pl.edu.wszib.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.NewPassModel;
import pl.edu.wszib.bank.model.view.RegistrationModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
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
    public boolean changePass(User user, NewPassModel newPass) {
        if(!user.getPass().equals(newPass.getOld_pass())) {
            return false;
        }

        User getUserFromDB = this.userDAO.getUserById(user.getId());
        getUserFromDB.setPass(newPass.getNew_pass());
        try {
            this.userDAO.updateUser(getUserFromDB);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean newUser(RegistrationModel registrationModel) {
        if(this.userDAO.getUserByLogin(registrationModel.getLogin()) != null) {
            return false;
        }

        User newUser = new User(0, registrationModel.getLogin(), registrationModel.getPass(), User.Role.USER);

        try {
            this.userDAO.persistUser(newUser);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean makeAccount(User chosenUser) {
        if(this.userDAO.getUserByLogin(chosenUser.getLogin()) == null) {
            return false;
        }

        Account newAcc = new Account(0, chosenUser);
        chosenUser.addnewAcctoList(newAcc);

        try {
            this.accountDAO.persistAccount(newAcc);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return this.userDAO.getUserByLogin(login);
    }
}
