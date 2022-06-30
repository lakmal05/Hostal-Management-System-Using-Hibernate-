package lk.ijse.hostel_Management.dao.custom.impl;

import lk.ijse.hostel_Management.dao.custom.RoomReservationDAO;
import lk.ijse.hostel_Management.entity.RoomReservation;
import lk.ijse.hostel_Management.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RoomReservationDAOImpl implements RoomReservationDAO {

    @Override
    public List<RoomReservation> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM RoomReservation ";
        Query query = session.createQuery(hql);
        List<RoomReservation> reservationList = query.list();

        transaction.commit();
        session.close();

        return reservationList;
    }

    @Override
    public boolean save(RoomReservation entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(RoomReservation entity) {
        return false;
    }

    @Override
    public boolean delete(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        RoomReservation reservation = session.load(RoomReservation.class, id);
        session.delete(reservation);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean exist(String s) {
        return false;
    }

    @Override
    public RoomReservation search(String s) {
        return null;
    }
    @Override
    public String generateNewID() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT res_id FROM RoomReservation  ORDER BY res_id DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        return list.isEmpty() ? "R-001" : String.format("R-%03d", (Integer.parseInt(list.get(0).replace("R-", "")) + 1));
    }

    @Override
    public boolean updateStatus(String res_id, String status) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="UPDATE RoomReservation SET status=: new_Status WHERE res_id=: reservationId";
        Query query = session.createQuery(hql);
        query.setParameter("new_Status",status);
        query.setParameter("reservationId",res_id);

        int i = query.executeUpdate();

        transaction.commit();
        session.close();

        if(i>0){
            return true;
        }
        return false;
    }



}
