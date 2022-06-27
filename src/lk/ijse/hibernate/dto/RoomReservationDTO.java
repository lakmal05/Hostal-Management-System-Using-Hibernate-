package lk.ijse.hibernate.dto;

import java.time.LocalDate;

public class RoomReservationDTO {

    private String resID;
    private LocalDate date;
    private String studentID;
    private String roomID;
    private String status;

    public RoomReservationDTO() {
    }

    public RoomReservationDTO(String resID, LocalDate date, String studentID, String roomID, String status) {
        this.resID = resID;
        this.date = date;
        this.studentID = studentID;
        this.roomID = roomID;
        this.status = status;
    }

    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomReservationDTO{" +
                "resID='" + resID + '\'' +
                ", date=" + date +
                ", studentID='" + studentID + '\'' +
                ", roomID='" + roomID + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
