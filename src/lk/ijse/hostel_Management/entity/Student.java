package lk.ijse.hostel_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    private String student_id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contactNo;
    private LocalDate DOB;
    private  String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<RoomReservation> reservations= new ArrayList<>();


    public Student(String student_id, String name, String address, String contactNo, LocalDate DOB, String gender) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.DOB = DOB;
        this.gender = gender;

    }


public  Student(String student_id){
        this.student_id=student_id;
}


}
