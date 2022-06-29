package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.CrudDAO;
import lk.ijse.hostel_Management.entity.RoomReservation;

public interface RoomReservationDAO extends CrudDAO<RoomReservation,String> {

    String generateNewID();

    boolean updateStatus(String res_id, String status);



}
