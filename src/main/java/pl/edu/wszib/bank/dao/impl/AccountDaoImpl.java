package pl.edu.wszib.bank.dao.impl;

public class AccountDaoImpl {
    /*
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

    @Override
    public List<Account> showAccountList(User user) {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.edu.wszib.bank.model.Account WHERE userID = :id");
        query.setParameter("id", user.getId());
        List<Account> accounts = query.getResultList();
        session.close();
        return accounts;
    }
     */
}
