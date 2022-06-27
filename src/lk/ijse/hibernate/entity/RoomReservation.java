package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class RoomReservation {
    @Id
    private String res_id;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",referencedColumnName = "student_id")
    private  Student student;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomID",referencedColumnName = "roomID")
    private  Room room;
    private String status;


}
