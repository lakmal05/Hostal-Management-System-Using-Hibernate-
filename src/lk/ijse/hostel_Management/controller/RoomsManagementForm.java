package lk.ijse.hostel_Management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel_Management.bo.BOFactory;
import lk.ijse.hostel_Management.bo.custom.RoomsBO;
import lk.ijse.hostel_Management.dto.RoomDTO;
import lk.ijse.hostel_Management.view.TM.RoomTM;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class RoomsManagementForm {


    public AnchorPane ManageRoomFormContext;
    public JFXTextField txtRoomID;
    public JFXTextField txtQty;
    public JFXTextField txtKeyMoney;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXComboBox<String> cmbRoomType;
    public TableView<RoomTM> tblRoom;
    public TableColumn colRoomID;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;

    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();



    RoomsBO manageRoomBO = (RoomsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MANAGEROOMS);

    public void initialize() throws Exception {

        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("roomId"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("type"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("keyMoney"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("qty"));

        loadRoomType();

        clearFields();
        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue==null);
            btnSave.setDisable(newValue==null);
            btnSave.setText(newValue !=null ? "Update":"Save");

            if (newValue != null){
                txtRoomID.setText(newValue.getRoomID());
                cmbRoomType.getSelectionModel().select(newValue.getType());
                txtKeyMoney.setText(newValue.getKey_money());
                txtQty.setText(String.valueOf(newValue.getQty()));


                txtRoomID.setDisable(false);
                cmbRoomType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtQty.setDisable(false);
            }

        });

        loadAllRoomDetails();

        Pattern idPattern = Pattern.compile("^(RI-)[0-9]{3,5}$");
        Pattern keyMoneyPattern = Pattern.compile("^[0-9]{4,6}$");
        Pattern qtyPattern = Pattern.compile("^[0-9]{1,3}$");


        //add pattern and text to the map
        map.put(txtRoomID,idPattern);
        map.put(txtKeyMoney,keyMoneyPattern);
        map.put(txtQty,qtyPattern);


    }

    private void loadAllRoomDetails() throws Exception {
        List<RoomDTO> allRooms = manageRoomBO.getAllRooms();
        for (RoomDTO roomDTO : allRooms) {
            tblRoom.getItems().add(new RoomTM(roomDTO.getRoomID(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty()));
        }
    }


    private void clearFields() {
        txtRoomID.clear();
        cmbRoomType.getSelectionModel().clearSelection();
        txtKeyMoney.clear();
        txtQty.clear();

        txtRoomID.setDisable(true);
        cmbRoomType.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtQty.setDisable(true);
    }

    public void loadRoomType(){
        cmbRoomType.getItems().add("Non-AC");
        cmbRoomType.getItems().add("Non-AC / Food");
        cmbRoomType.getItems().add("AC");
        cmbRoomType.getItems().add("AC / Food");
    }



    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        if (btnSave.getText().equalsIgnoreCase("Add")) {
            ObservableList<RoomTM> items = tblRoom.getItems();
            for (RoomTM item : items) {
                if (item.getRoomID().equalsIgnoreCase(cmbRoomType.getValue())) {
                    int qty = item.getQty() + Integer.parseInt(txtQty.getText());
                    if (manageRoomBO.updateQty(item.getRoomID(), qty)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated..!").show();
                        item.setQty(qty);
                        txtQty.setText(String.valueOf(item.getQty()));
                        txtQty.clear();
                    }
                }
            }
            tblRoom.refresh();
        } else if (btnSave.getText().equalsIgnoreCase("Save")) {
            if (manageRoomBO.saveRoom(new RoomDTO(txtRoomID.getText(), cmbRoomType.getValue(), txtKeyMoney.getText(), Integer.parseInt(txtQty.getText())))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
                tblRoom.getItems().add(new RoomTM(txtRoomID.getText(), cmbRoomType.getValue(), txtKeyMoney.getText(), Integer.parseInt(txtQty.getText())));
                tblRoom.refresh();
                txtRoomID.clear();
                cmbRoomType.getSelectionModel().clearSelection();
                txtKeyMoney.clear();
                txtQty.clear();

                btnSave.setDisable(true);
                txtRoomID.setVisible(false);
                txtRoomID.setVisible(true);
                cmbRoomType.setDisable(true);
                txtKeyMoney.setDisable(true);
                txtQty.setDisable(true);
            }
        } else if (btnSave.getText().equalsIgnoreCase("Update")) {
            if (manageRoomBO.updateRoom(new RoomDTO(txtRoomID.getText(), cmbRoomType.getValue(), txtKeyMoney.getText(), Integer.parseInt(txtQty.getText())))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated..!").show();
                RoomTM selectedItem = tblRoom.getSelectionModel().getSelectedItem();
                selectedItem.setKey_money(txtKeyMoney.getText());
                selectedItem.setQty(Integer.parseInt(txtQty.getText()));
                selectedItem.setType(cmbRoomType.getValue());
                tblRoom.refresh();
            }
        }

    }
    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        String roomId = tblRoom.getSelectionModel().getSelectedItem().getRoomID();

        Alert alert=new Alert(Alert.AlertType.WARNING,"Are You Sure ?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            if (manageRoomBO.deleteRoom(roomId)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted..!").show();
                tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
                tblRoom.getSelectionModel().clearSelection();
                clearFields();
            }
        }
    }


    public void textFields_Key_Released(KeyEvent keyEvent) {
      /*  ValidationUtil.validate(map,btnSave);

        if (keyEvent.getCode()== KeyCode.ENTER){
            Object response = ValidationUtil.validate(map,btnSave);
            if (response instanceof JFXTextField){
                JFXTextField textField = (JFXTextField) response;
                textField.requestFocus();
            }else if (response instanceof Boolean){

            }
        }*/
    }


   

    public void btnAddNewRoomOnAction(ActionEvent actionEvent) {
        txtRoomID.setDisable(false);
        cmbRoomType.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtQty.setDisable(false);

        txtRoomID.clear();
        cmbRoomType.getSelectionModel().clearSelection();
        txtKeyMoney.clear();
        txtQty.clear();
        tblRoom.getSelectionModel().clearSelection();

        btnDelete.setDisable(true);
        btnSave.setDisable(false);
        btnSave.setText("Save");
        txtKeyMoney.requestFocus();



    }
}
