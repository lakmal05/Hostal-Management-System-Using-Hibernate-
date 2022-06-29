package lk.ijse.hostel_Management.dto;

import lk.ijse.hostel_Management.entity.Room;
import lk.ijse.hostel_Management.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class RoomReservationDTO {

    private String resId;
    private LocalDate date;
    private String status;



    private Student student;
    private Room room;



}
