package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.MakeReservationBO;
import lk.ijse.hostel_Management.dao.DAOFactory;
import lk.ijse.hostel_Management.dao.custom.RoomDAO;
import lk.ijse.hostel_Management.dao.custom.RoomReservationDAO;
import lk.ijse.hostel_Management.dao.custom.StudentDAO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;
import lk.ijse.hostel_Management.entity.Room;
import lk.ijse.hostel_Management.entity.RoomReservation;
import lk.ijse.hostel_Management.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MakeReservationBOImpl implements MakeReservationBO {

    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final RoomReservationDAO reservationDAO = (RoomReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        List<Student> all = studentDAO.getAll();
        List<StudentDTO> allStudents=new ArrayList<>();
        for (Student student : all) {
            allStudents.add(new StudentDTO(student.getStudent_id(),student.getName(),student.getAddress(),student.getContactNo(),student.getDOB(),student.getGender()));
        }
        return allStudents;
    }

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> allRooms=new ArrayList<>();
        for (Room room : all) {
            allRooms.add(new RoomDTO(room.getRoomID(),room.getType(),room.getKey_money(),room.getQty()));
        }
        return allRooms;
    }

    @Override
    public String generateNewReservationID() throws IOException {
        return reservationDAO.generateNewID();
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(studentDTO.getStudent_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContactNo(),studentDTO.getDOB(),studentDTO.getGender()));
    }

    @Override
    public boolean checkTheStudentIsExist(String studentId) throws IOException {
        return studentDAO.exist(studentId);
    }

    @Override

    public boolean saveReservation(RoomReservationDTO reservationDTO) throws Exception {
        return reservationDAO.save(new RoomReservation(reservationDTO.getResId(),reservationDTO.getDate(),reservationDTO.getStatus(),reservationDTO.getStudent(),reservationDTO.getRoom()));
    }

    @Override
    public List<RoomReservationDTO> getAllReservations() throws Exception {
        List<RoomReservation> all = reservationDAO.getAll();
        List<RoomReservationDTO> allReservations=new ArrayList<>();
        for (RoomReservation reservation : all) {
            allReservations.add(new RoomReservationDTO(reservation.getRes_id(),reservation.getDate(),reservation.getStatus(),reservation.getStudent(),reservation.getRoom()));
        }
        return allReservations;
    }

    @Override
    public boolean updateRoomDetails(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(roomDTO.getRoomID(),roomDTO.getType(),roomDTO.getKeyMoney(),roomDTO.getQty()));
    }



}
