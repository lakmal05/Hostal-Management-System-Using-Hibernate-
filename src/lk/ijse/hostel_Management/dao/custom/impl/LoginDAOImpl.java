package lk.ijse.hostel_Management.dao.custom.impl;

import lk.ijse.hostel_Management.dao.custom.LoginDAO;
import lk.ijse.hostel_Management.entity.User;
import lk.ijse.hostel_Management.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public List<User> getAllUsers() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();

        transaction.commit();
        session.close();

        return users;
    }


}
