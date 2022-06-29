package lk.ijse.hostel_Management.bo.custom;

import java.util.List;

public interface RoomsBO {

    List<RoomDTO> getAllRooms() throws Exception;

    boolean updateQty(String roomTypeID, int qty);

    boolean saveRoom(RoomDTO roomDTO) throws Exception;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

    boolean deleteRoom(String id) throws Exception;

}
