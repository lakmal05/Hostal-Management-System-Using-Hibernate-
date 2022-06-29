package lk.ijse.hostel_Management.view.TM;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class RoomTM {

    private String roomID;
    private String type;
    private double key_money;
    private int qty;


}
