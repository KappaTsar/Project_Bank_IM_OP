package pl.edu.wszib.bank.services;

import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    void changePass(User user);
    boolean newUser(RegistrationModel registrationModel);
    boolean makeAccount(User curUser);
    User getUserById(int id);
    User getUserByLogin(String login);
}
