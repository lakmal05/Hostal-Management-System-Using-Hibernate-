package lk.ijse.hostel_Management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentDTO {

    private String student_id;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate DOB;
    private  String gender;



    @Override
    public String toString() {
        return "StudentDTO{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", DOB='" + DOB + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
