package lk.ijse.hostel_Management.bo.custom;

import java.util.List;

public interface ReservationDetailsBO {

    List<ReservationDTO> getAllReservations() throws Exception;

    boolean removeReservation(String id) throws Exception;

    boolean updateRoomQty(String roomTypeID, int qty);

    RoomDTO getRoom(String roomTypeID);

    boolean updateReservationStatus(String res_Id ,String status);

    StudentDTO getStudent(String studentId);


}
