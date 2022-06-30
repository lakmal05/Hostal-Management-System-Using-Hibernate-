package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.ReservationDetailsBO;
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

public class ReservationDetailsBOImpl  implements ReservationDetailsBO {


    private final RoomReservationDAO reservationDAO = (RoomReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

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
    public boolean removeReservation(String id) throws Exception {
        return reservationDAO.delete(id);
    }

    @Override
    public boolean updateRoomQty(String roomTypeID, int qty) throws IOException {
        return roomDAO.updateQty(roomTypeID,qty);
    }

    @Override
    public RoomDTO getRoom(String roomTypeID) throws IOException {
        Room room = roomDAO.search(roomTypeID);
        return new RoomDTO(room.getRoomID(),room.getType(),room.getKey_money(),room.getQty());
    }

    @Override
    public boolean updateReservationStatus(String res_id, String status) throws IOException {
        return reservationDAO.updateStatus(res_id,status);
    }

    @Override
    public StudentDTO getStudent(String studentId) throws IOException {
        Student student = studentDAO.search(studentId);
        return new StudentDTO(student.getStudent_id(),student.getName(),student.getAddress(),student.getContactNo(),student.getDOB(),student.getGender());
    }


}
