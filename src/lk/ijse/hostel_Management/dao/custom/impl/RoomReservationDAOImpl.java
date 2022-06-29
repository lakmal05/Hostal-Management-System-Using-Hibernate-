package lk.ijse.hostel_Management.dao.custom.impl;

import lk.ijse.hostel_Management.dao.custom.RoomReservationDAO;
import lk.ijse.hostel_Management.entity.RoomReservation;
import lk.ijse.hostel_Management.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomReservationDAOImpl implements RoomReservationDAO {

    @Override
    public List<RoomReservation> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="FROM Reservation";
        Query query = session.createQuery(hql);
        List<Reservation> reservationList = query.list();

        transaction.commit();
        session.close();

        return reservationList;
    }

    @Override
    public boolean save(RoomReservation entity) {
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
    public boolean delete(String id) {
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
    public String generateNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT resId FROM Reservation ORDER BY resId DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        return list.isEmpty() ? "R-001" : String.format("R-%03d", (Integer.parseInt(list.get(0).replace("R-", "")) + 1));
    }

    @Override
    public boolean updateStatus(String res_id, String status) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="UPDATE Reservation SET status=: new_Status WHERE resId=: reservationId";
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
