package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.StudentBO;
import lk.ijse.hostel_Management.dao.DAOFactory;
import lk.ijse.hostel_Management.dao.custom.StudentDAO;
import lk.ijse.hostel_Management.dto.StudentDTO;
import lk.ijse.hostel_Management.entity.Student;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> all = studentDAO.getAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student : all) {
            studentDTOList.add(new StudentDTO(student.getStudent_id(), student.getName(), student.getAddress(), student.getContactNo(), student.getDOB(), student.getGender()));
        }
        return studentDTOList;
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @SneakyThrows
    @Override
    public boolean checkStudentIsExists(String id) {
        return studentDAO.exist(id);
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return studentDAO.save(new Student(dto.getStudent_id(), dto.getName(), dto.getAddress(), dto.getContactNo(), dto.getDOB(), dto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return studentDAO.update(new Student(dto.getStudent_id(), dto.getName(), dto.getAddress(), dto.getContactNo(), dto.getDOB(), dto.getGender()));
    }



}
