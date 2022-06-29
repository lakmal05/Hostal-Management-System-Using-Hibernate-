package lk.ijse.hostel_Management.view.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ReservationTM {

    private String res_id;
    private LocalDate date;
    private String room_id;
   private String student_id;
    private String status;



}
