package lk.ijse.hostel_Management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_Management.bo.BOFactory;
import lk.ijse.hostel_Management.bo.custom.ReservationDetailsBO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.dto.RoomReservationDTO;
import lk.ijse.hostel_Management.dto.StudentDTO;
import lk.ijse.hostel_Management.view.TM.ReservationTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ReservationDetailForm {

    private final ReservationDetailsBO reservationDetailsBO = (ReservationDetailsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATIONDETAILS);
    public AnchorPane ReservationDetailsFormContext;
    public JFXTextField txtReservationID;
    public JFXTextField txtRoomID;
    public JFXTextField txtAddress;
    public JFXTextField txtStudentID;
    public JFXTextField txtDate;
    public JFXTextField txtName;
    public JFXTextField txtDOB;
    public JFXTextField txtStatus;
    public JFXTextField txtGender;
    public JFXButton btnUpdate;
    public TableView <ReservationTM>tblReservationDetails;
    public JFXTextField txtContact;

    public void initialize() throws Exception {
        disableFields();


        tblReservationDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("resID"));
        tblReservationDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("date"));
        tblReservationDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("roomId"));
        tblReservationDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("studentId"));
        tblReservationDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("status"));
        TableColumn<ReservationTM, Button> lastCol = (TableColumn<ReservationTM, Button>) tblReservationDetails.getColumns().get(5);
        lastCol.setCellValueFactory(param -> {
            Button btnRemove = new Button("Remove");
            btnRemove.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    try {
                        if (reservationDetailsBO.removeReservation(param.getValue().getRes_id())) {
                            tblReservationDetails.getItems().remove(param.getValue());
                            new Alert(Alert.AlertType.CONFIRMATION, "Removed..!!").show();
                            RoomDTO roomDTO = reservationDetailsBO.getRoom(param.getValue().getRoom_id());
                            reservationDetailsBO.updateRoomQty(roomDTO.getRoomID(), roomDTO.getQty() + 1);

                            clearFields();

                            btnUpdate.setDisable(true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return new ReadOnlyObjectWrapper<>(btnRemove);
        });

        tblReservationDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtReservationID.setDisable(false);
                txtDate.setDisable(false);
                txtStatus.setDisable(false);
                txtRoomID.setDisable(false);
                txtStudentID.setDisable(false);

                txtReservationID.setEditable(false);
                txtDate.setEditable(false);
                txtStudentID.setEditable(false);
                txtRoomID.setEditable(false);

                txtName.setDisable(false);
                txtName.setEditable(false);
                txtAddress.setDisable(false);
                txtAddress.setEditable(false);
                txtContact.setDisable(false);
                txtContact.setEditable(false);
                txtDOB.setDisable(false);
                txtDOB.setEditable(false);
                txtGender.setDisable(false);
                txtGender.setEditable(false);

                txtReservationID.setText(newValue.getRes_id());
                txtDate.setText(String.valueOf(newValue.getDate()));
                txtRoomID.setText(newValue.getRoom_id());
                txtStatus.setText(newValue.getStatus());
                btnUpdate.setDisable(false);


                StudentDTO student = null;
                try {
                    student = reservationDetailsBO.getStudent(newValue.getStudent_id());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                txtStudentID.setText(student.getStudent_id());
                txtName.setText(student.getName());
                txtAddress.setText(student.getAddress());
                txtContact.setText(student.getContactNo());
                txtDOB.setText(String.valueOf(student.getDOB()));
                txtGender.setText(student.getGender());

                txtStatus.requestFocus();
            }
        });

        loadAllReservationDetails();


    }
    private void disableFields() {
        btnUpdate.setDisable(true);
        txtReservationID.setDisable(true);
        txtDate.setDisable(true);
        txtStudentID.setDisable(true);
        txtRoomID.setDisable(true);
        txtStatus.setDisable(true);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtDOB.setDisable(true);
        txtGender.setDisable(true);
    }

    private void clearFields() {
        tblReservationDetails.getSelectionModel().clearSelection();
        txtReservationID.clear();
        txtDate.clear();
        txtRoomID.clear();
        txtStatus.clear();
        txtStudentID.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDOB.clear();
        txtGender.clear();
    }

    private void loadAllReservationDetails() throws Exception {
        List<RoomReservationDTO> allReservations = reservationDetailsBO.getAllReservations();
        for (RoomReservationDTO dto : allReservations) {
            tblReservationDetails.getItems().add(new ReservationTM(dto.getResId(), dto.getDate(), dto.getRoom().getRoomID(), dto.getStudent().getStudent_id(), dto.getStatus()));
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        ReservationTM selectedItem = tblReservationDetails.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (reservationDetailsBO.updateReservationStatus(selectedItem.getRes_id(), txtStatus.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
                selectedItem.setStatus(txtStatus.getText());
                tblReservationDetails.refresh();
                clearFields();
                disableFields();
                tblReservationDetails.requestFocus();
            }
        }
    }
    }

























