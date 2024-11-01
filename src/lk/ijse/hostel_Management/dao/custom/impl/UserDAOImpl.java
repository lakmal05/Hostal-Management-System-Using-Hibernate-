package lk.ijse.hostel_Management.dao.custom.impl;

import lk.ijse.hostel_Management.dao.custom.UserDAO;
import lk.ijse.hostel_Management.entity.User;
import lk.ijse.hostel_Management.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public boolean save(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(User.class, s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String s) {
        return false;
    }

    @Override
    public User search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<User> getMatchingResults(String search) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User WHERE nic Like :NIC OR name LIKE :Name OR userName LIKE :UserName OR password LIKE :Password ")
                .setParameter("NIC", search)
                .setParameter("Name", search)
                .setParameter("UserName", search)
                .setParameter("Password", search).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public HashMap<String, String> getAllUserNPasswordMap() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list = session.createQuery("SELECT userName, password FROM User").list();
        transaction.commit();
        session.close();
        HashMap<String, String> userMap = new HashMap<>();
        list.stream().forEach(o -> userMap.put((String)o[0],(String)o[1]));
        return userMap;
    }

}
