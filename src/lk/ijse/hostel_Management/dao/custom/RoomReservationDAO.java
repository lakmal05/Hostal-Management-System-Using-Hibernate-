package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.CrudDAO;
import lk.ijse.hostel_Management.entity.RoomReservation;

import java.io.IOException;

public interface RoomReservationDAO extends CrudDAO<RoomReservation,String> {

    String generateNewID() throws IOException;

    boolean updateStatus(String res_id, String status) throws IOException;



}
