package lk.ijse.hostel_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class RoomReservation {
    @Id
    private String res_id;
   @CreationTimestamp
    private LocalDate date;
    private String status;


    @ManyToOne
    private  Student student;


    @ManyToOne
    private  Room room;


}
