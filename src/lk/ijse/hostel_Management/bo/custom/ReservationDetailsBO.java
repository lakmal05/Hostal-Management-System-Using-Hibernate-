package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.bo.SuperBO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface ReservationDetailsBO  extends SuperBO {

    List<RoomReservationDTO> getAllReservations() throws Exception;

    boolean removeReservation(String id) throws Exception;

    boolean updateRoomQty(String roomTypeID, int qty) throws IOException;

    RoomDTO getRoom(String roomTypeID) throws IOException;

    boolean updateReservationStatus(String res_Id ,String status) throws IOException;

    StudentDTO getStudent(String studentId) throws IOException;


}
