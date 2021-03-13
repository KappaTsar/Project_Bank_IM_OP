package pl.edu.wszib.bank.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.model.TransactionDetails;
import pl.edu.wszib.bank.model.User;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

@Repository
public class TransactionDaoImpl implements ITransactionDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean saveTrans(TransactionDetails transaction) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(transaction);
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

    @Override
    public TransactionDetails getTransById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<TransactionDetails> query = session.createQuery("FROM pl.edu.wszib.bank.model.TransactionDetails WHERE id = :id");
        query.setParameter("id", id);
        TransactionDetails result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Transaction doesn't exist !!");
        }
        session.close();
        return result;
    }
}
