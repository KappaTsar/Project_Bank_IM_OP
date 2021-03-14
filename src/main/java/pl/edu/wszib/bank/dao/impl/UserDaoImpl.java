package pl.edu.wszib.bank.dao.impl;

public class UserDaoImpl {
    /*
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.bank.model.User WHERE login = :login");
        query.setParameter("login", login);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User doesn't exist !!");
        }
        session.close();
        return result;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.bank.model.User WHERE id = :id");
        query.setParameter("id", id);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User doesn't exist !!");
        }
        session.close();
        return result;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();

            }
        } finally {
            session.close();
        }
    }

    @Override
    public boolean persistUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
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
     */
}


