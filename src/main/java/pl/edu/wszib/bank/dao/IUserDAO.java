package pl.edu.wszib.bank.dao;

import pl.edu.wszib.bank.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    User getUserById(int id);
    void updateUser(User user);
    boolean persistUser(User user);
}