package lk.ijse.hostel_Management.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel_Management.bo.BOFactory;
import lk.ijse.hostel_Management.bo.custom.LoginBO;

public class LoginPage {

  private LoginBO loginBO=(LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);

    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public AnchorPane loginFormContext;

    public void LoginOnAction(ActionEvent actionEvent) {

      try {
        if(loginBO.checkCredentials(txtUserName.getText(),pwdPassword.getText())){
          Stage stage =(Stage) loginFormContext.getScene().getWindow();
          stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
          stage.centerOnScreen();
        }else{
          new Alert(Alert.AlertType.WARNING,"Incorrect UserName Or Password", ButtonType.OK).show();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }



    public void visible_Invisible(ActionEvent actionEvent) {
    }
}
