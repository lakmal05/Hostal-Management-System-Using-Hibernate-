package lk.ijse.hostel_Management.bo.custom;

import java.util.List;

public interface MakeReservationBO {
    List<StudentDTO> getAllStudents() throws Exception;

    List<RoomDTO> getAllRooms() throws Exception;

    String generateNewReservationID();

    boolean saveStudent(StudentDTO studentDTO) throws Exception;

    boolean checkTheStudentIsExist(String studentId);

    boolean saveReservation(ReservationDTO reservationDTO) throws Exception;

    List<ReservationDTO> getAllReservations() throws Exception;

    boolean updateRoomDetails(RoomDTO roomDTO) throws Exception;


}
