package pl.edu.wszib.bank.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.bank.dao.IAccountDAO;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.User;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

@Repository
public class AccountDaoImpl implements IAccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void updateAccount(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(account);
            tx.commit();
        } catch (Exception e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Account getAccountByNUM(String NUM) {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.edu.wszib.bank.model.Account WHERE accNumber = :accNumber");
        query.setParameter("accNumber", NUM);
        Account result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Account doesn't exist !!");
        }
        session.close();
        return result;
    }

    @Override
    public Account getAccountByID(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.edu.wszib.bank.model.Account WHERE id = :id");
        query.setParameter("id", id);
        Account result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Account doesn't exist !!");
        }
        session.close();
        return result;
    }

    @Override
    public boolean persistAccount(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(account);
            tx.commit();
            return true;
        } catch (Exception e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
