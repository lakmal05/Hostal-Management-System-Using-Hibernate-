package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.dto.StudentDTO;

import java.util.List;

public interface StudentBO {
    List<StudentDTO> getAllStudents() throws Exception;

    boolean deleteStudent(String studentId) throws Exception;

    boolean checkStudentIsExists(String id);

    boolean saveStudent(StudentDTO dto) throws Exception;

    boolean updateStudent(StudentDTO dto) throws Exception;



}
