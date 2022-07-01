package lk.ijse.hostel_Management.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_Management.bo.BOFactory;
import lk.ijse.hostel_Management.bo.custom.KeyMoneyDetailsBO;
import lk.ijse.hostel_Management.view.TM.keyMoneyDetailsTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class KeyMoneyForm {
    public AnchorPane KeyMoneyContext;
    public TableView<keyMoneyDetailsTM> tblKeyMoney;
    public Label lblDate;
    public Label lblTime;



    private final KeyMoneyDetailsBO keyMoneyRemainStudentsBO = (KeyMoneyDetailsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.KEYMONEYREMAINSTUDENTS);



    public void initialize() throws IOException {
        tblKeyMoney.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("studentId"));
        tblKeyMoney.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("name"));
        tblKeyMoney.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("address"));
        tblKeyMoney.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("contactNo"));
        tblKeyMoney.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("resId"));
        tblKeyMoney.getColumns().get(5).setCellValueFactory(new PropertyValueFactory("date"));
        tblKeyMoney.getColumns().get(6).setCellValueFactory(new PropertyValueFactory("roomId"));
        tblKeyMoney.getColumns().get(7).setCellValueFactory(new PropertyValueFactory("status"));

        loadAllData();
    }

    private void loadAllData() throws IOException {
        List<Object[]> list = keyMoneyRemainStudentsBO.getKeyMoneyAndStudentDetails();
        for (Object[] objects : list) {
            String stu_Id= (String) objects[0];
            String name= (String) objects[1];
            String address= (String) objects[2];
            String con_No= (String) objects[3];
            String res_Id= (String) objects[4];
            LocalDate date= (LocalDate) objects[5];
            String roomId= (String) objects[6];
            String status= (String) objects[7];
            tblKeyMoney.getItems().add(new keyMoneyDetailsTM(stu_Id,name,address,con_No,res_Id,date,roomId,status));
        }
    }


    public void navigateToHome(MouseEvent mouseEvent) {
    }
}
