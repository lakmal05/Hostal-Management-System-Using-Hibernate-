package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;

import java.util.List;

public interface MakeReservationBO {
    List<StudentDTO> getAllStudents() throws Exception;

    List<RoomDTO> getAllRooms() throws Exception;

    String generateNewReservationID();

    boolean saveStudent(StudentDTO studentDTO) throws Exception;

    boolean checkTheStudentIsExist(String studentId);

    boolean saveReservation(RoomReservationDTO reservationDTO) throws Exception;

    List<RoomReservationDTO> getAllReservations() throws Exception;

    boolean updateRoomDetails(RoomDTO roomDTO) throws Exception;


}
