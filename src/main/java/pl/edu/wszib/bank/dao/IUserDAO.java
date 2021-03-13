package pl.edu.wszib.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.bank.model.User;

public interface IUserDAO extends JpaRepository<User, Integer> {
    User findUserByLogin(String login);
    User findUserById(int id);
}