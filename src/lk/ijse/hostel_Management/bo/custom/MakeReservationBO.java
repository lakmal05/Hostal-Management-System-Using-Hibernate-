package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.bo.SuperBO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface MakeReservationBO  extends SuperBO {
    List<StudentDTO> getAllStudents() throws Exception;

    List<RoomDTO> getAllRooms() throws Exception;

    String generateNewReservationID() throws IOException;

    boolean saveStudent(StudentDTO studentDTO) throws Exception;

    boolean checkTheStudentIsExist(String studentId) throws IOException;

    boolean saveReservation(RoomReservationDTO reservationDTO) throws Exception;

    List<RoomReservationDTO> getAllReservations() throws Exception;

    boolean updateRoomDetails(RoomDTO roomDTO) throws Exception;


}
