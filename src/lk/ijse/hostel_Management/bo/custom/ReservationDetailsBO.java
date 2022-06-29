package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;

import java.util.List;

public interface ReservationDetailsBO {

    List<RoomReservationDTO> getAllReservations() throws Exception;

    boolean removeReservation(String id) throws Exception;

    boolean updateRoomQty(String roomTypeID, int qty);

    RoomDTO getRoom(String roomTypeID);

    boolean updateReservationStatus(String res_Id ,String status);

    StudentDTO getStudent(String studentId);


}
