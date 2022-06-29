package lk.ijse.hostel_Management.view.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class keyMoneyDetailsTM {

    String student_id;
    String name;
    String address;
    String contact_no;
    String resId;

    LocalDate date;
    String room_id;
    String status;


}
