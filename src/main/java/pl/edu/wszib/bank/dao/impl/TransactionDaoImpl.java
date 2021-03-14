package pl.edu.wszib.bank.dao.impl;

public class TransactionDaoImpl{
    /*
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
     */
}
