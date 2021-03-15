package pl.edu.wszib.bank.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.bank.dao.ITransactionDAO;
import pl.edu.wszib.bank.model.TransactionDetails;

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
}
