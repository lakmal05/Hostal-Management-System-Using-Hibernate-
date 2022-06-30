package lk.ijse.hostel_Management.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_Management.bo.BOFactory;
import lk.ijse.hostel_Management.bo.custom.MakeReservationBO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;
import lk.ijse.hostel_Management.entity.Room;
import lk.ijse.hostel_Management.entity.Student;
import lk.ijse.hostel_Management.view.TM.ReservationTM;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RoomsReservationForm {


    public AnchorPane ReservationFormContext;
    public JFXTextField txtAddress;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public JFXTextField txtDOB;
    public JFXTextField txtContact;
    public JFXTextField txtPaidAmount;
    public JFXComboBox<StudentDTO> cmbStudentID;
    public JFXComboBox<RoomDTO> cmbRoomID;
    public JFXComboBox cmbGender;
    public JFXTextField txtName;
    public JFXTextField txtType;
    public Label lblReservationID;
    public TableView <ReservationTM>tblReservationDetail;
    public Label lblDate;
    public Label lblTime;

    MakeReservationBO makeReservationBO = (MakeReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MAKERESERVATION);

    public void initialize() throws Exception {

        tblReservationDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("resID"));
        tblReservationDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("date"));
        tblReservationDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("roomId"));
        tblReservationDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("studentId"));
        tblReservationDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("status"));

        lblReservationID.setText(generateNewReservationID());




        clearFields();
        List<StudentDTO> allStudents = makeReservationBO.getAllStudents();
        for (StudentDTO studentDTO : allStudents) {
            cmbStudentID.getItems().add(studentDTO);
        }

        List<RoomDTO> allRooms = makeReservationBO.getAllRooms();
        for (RoomDTO roomDTO : allRooms) {
            cmbRoomID.getItems().add(roomDTO);
        }

        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("FeMale");

        cmbStudentID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                txtName.setDisable(false);
                txtAddress.setDisable(false);
                txtContact.setDisable(false);
                txtDOB.setDisable(false);
                cmbGender.setDisable(false);
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(newValue.getContactNo());
                txtDOB.setText(String.valueOf(newValue.getDOB()));
                cmbGender.getSelectionModel().select(newValue.getGender());
            }
        });

        cmbRoomID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null){
                txtType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtQty.setDisable(false);
                txtType.setText(newValue.getType());
                txtKeyMoney.setText(newValue.getKeyMoney());
                txtQty.setText(String.valueOf(newValue.getQty()));
              //  btnReservation.setDisable(false);
            }
        });

        loadAllReservationDetails();
    }

    private void loadAllReservationDetails() throws Exception {
        List<RoomReservationDTO> allReservations = makeReservationBO.getAllReservations();
        for (RoomReservationDTO reservationDTO : allReservations) {
            tblReservationDetail.getItems().add(new ReservationTM(reservationDTO.getResId(),reservationDTO.getDate(),reservationDTO.getRoom().getRoomID(),reservationDTO.getStudent().getStudent_id(),reservationDTO.getStatus()));
        }
    }

    public String generateNewReservationID() throws IOException {
        return makeReservationBO.generateNewReservationID();
    }

    private void clearFields() {
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtDOB.setDisable(true);
        cmbGender.setDisable(true);

        txtName.setEditable(false);
        txtAddress.setEditable(false);
        txtContact.setEditable(false);
        txtDOB.setEditable(false);
        cmbGender.setEditable(false);

        txtType.setDisable(true);
        txtType.setEditable(false);
        txtKeyMoney.setDisable(true);
        txtKeyMoney.setEditable(false);
        txtQty.setDisable(true);
        txtQty.setEditable(false);
      //  btnReservation.setDisable(true);
    }




    public void btnReservationOnAction(ActionEvent actionEvent) throws Exception {
        double keyMoney=Double.parseDouble(txtKeyMoney.getText());
        double paidKeyMoney=Double.parseDouble(txtPaidAmount.getText());
        String status="";
        if (keyMoney==paidKeyMoney){
            status="Paid";
        }else{
            double balanceToPay=keyMoney-paidKeyMoney;
            status=String.valueOf(balanceToPay);
        }

        StudentDTO studentDTO = cmbStudentID.getValue();
        Student student=new Student(studentDTO.getStudent_id(),studentDTO.getName(),studentDTO.getAddress(),studentDTO.getContactNo(),studentDTO.getDOB(),studentDTO.getGender());

        RoomDTO roomDTO = cmbRoomID.getValue();
        Room room=new Room(roomDTO.getRoomID(),roomDTO.getType(),roomDTO.getKeyMoney(),roomDTO.getQty()-1);

        if (makeReservationBO.saveReservation(new RoomReservationDTO(lblReservationID.getText(), LocalDate.parse(lblDate.getText()),status,student,room))) {
            tblReservationDetail.getItems().add(new ReservationTM(lblReservationID.getText(),LocalDate.parse(lblDate.getText()),room.getRoomID(),student.getStudent_id(),status));
            new Alert(Alert.AlertType.CONFIRMATION,"Reserved").show();
            makeReservationBO.updateRoomDetails(new RoomDTO(room.getRoomID(),room.getType(),room.getKey_money(),room.getQty()));
            txtPaidAmount.clear();
            cmbStudentID.getSelectionModel().clearSelection();
            cmbRoomID.getSelectionModel().clearSelection();
          //  btnReservation.setDisable(true);
            txtName.clear();
            txtAddress.clear();
            txtContact.clear();
            txtDOB.clear();
            cmbGender.getSelectionModel().clearSelection();
            txtType.clear();
            txtKeyMoney.clear();
            txtQty.clear();
            lblReservationID.setText(generateNewReservationID());
        }

    }












}
