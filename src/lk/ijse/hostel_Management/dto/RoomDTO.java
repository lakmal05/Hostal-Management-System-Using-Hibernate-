package lk.ijse.hostel_Management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class RoomDTO {





    private String roomID;
    private String type;
    private Double keyMoney;
    private  int qty;



    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomID='" + roomID + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", qty=" + qty +
                '}';
    }
}
