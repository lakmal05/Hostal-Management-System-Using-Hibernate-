package lk.ijse.hostel_Management.entity;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data


public class Room {

    @Id
    private String roomID;
    private String type;
    private double key_money;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomReservation> reservationsList= new ArrayList<>();





    public Room(String roomID, String type, double key_money, int qty) {
        this.roomID = roomID;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }


    public  Room(String room_id){
        this.roomID=room_id;
    }

}
