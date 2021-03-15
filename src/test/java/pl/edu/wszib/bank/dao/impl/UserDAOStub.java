package pl.edu.wszib.bank.dao.impl;

import pl.edu.wszib.bank.dao.IUserDAO;
import pl.edu.wszib.bank.model.User;

public class UserDAOStub implements IUserDAO {
    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void updateUser(User user) {   }

    @Override
    public boolean persistUser(User user) {
        return true;
    }
}
