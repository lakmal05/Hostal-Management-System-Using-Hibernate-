package lk.ijse.hibernate.entity;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Room {

    @Id
    private String roomID;
    private String type;
    private double key_money;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomReservation> roomDetails;



    public Room() {
    }

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
