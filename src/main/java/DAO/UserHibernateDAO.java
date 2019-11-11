package DAO;

import Model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;


import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        sessionFactory = DBHelper.getSessionFactory();
    }


    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }


    @Override
    public boolean deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE name= :name");
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE id= :id");
        query.setParameter("id", id);
        User user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }
}

