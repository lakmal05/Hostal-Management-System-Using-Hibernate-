package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.CrudDAO;
import lk.ijse.hostel_Management.entity.Room;

public interface RoomDAO extends CrudDAO<Room,String> {

    boolean updateQty(String roomTypeID, int qty);

}
