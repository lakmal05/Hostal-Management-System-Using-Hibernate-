package lk.ijse.hostel_Management.entity;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Room {

    @Id
    private String roomID;
    private String type;
    private String key_money;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomReservation> reservationsList= new ArrayList<>();





    public Room(String roomID, String type, String key_money, int qty) {
        this.roomID = roomID;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }


  /*  public  Room(String room_id){
        this.roomID=room_id;
    }*/

}
