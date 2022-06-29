package lk.ijse.hostel_Management.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import javax.persistence.*;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    private String student_id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contactNo;
    private String DOB;
    private  String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<RoomReservation>reservations;


    public Student(String student_id, String name, String address, String contactNo, String DOB, String gender) {
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
