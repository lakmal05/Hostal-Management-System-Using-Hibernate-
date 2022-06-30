package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.bo.SuperBO;
import lk.ijse.hostel_Management.dto.RoomDTO;

import java.io.IOException;
import java.util.List;

public interface RoomsBO  extends SuperBO {

    List<RoomDTO> getAllRooms() throws Exception;

    boolean updateQty(String roomTypeID, int qty) throws IOException;

    boolean saveRoom(RoomDTO roomDTO) throws Exception;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

    boolean deleteRoom(String id) throws Exception;

}
