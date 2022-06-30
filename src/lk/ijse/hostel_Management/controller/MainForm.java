package lk.ijse.hostel_Management.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainForm {
    public AnchorPane MainPageConetxt;
    public ImageView imgBookingRoom;
    public ImageView imgStudents;
    public ImageView imgKeyMoney;
    public ImageView imgBookingDetaiks;
    public Label lblMenu;
    public Label lblDescription;
    public Label lblDate;
    public Label lblTime;



    public  void  initialize(){


    }


    public void navigate(MouseEvent mouseEvent) throws IOException {

        if(mouseEvent.getSource()instanceof ImageView){
            ImageView icon =(ImageView) mouseEvent.getSource();

            Parent MainPageConetxt= null;

            switch (icon.getId()){
                case "imgBookingRoom":
                    MainPageConetxt = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hostel_Management/view/rooms-reservation-form.fxml"));
                    break;

                case "imgStudents":
                    MainPageConetxt =FXMLLoader.load(this.getClass().getResource("/lk/ijse/hostel_Management/view/student-management-form.fxml"));
                    break;

                case "imgKeyMoney" :
                    MainPageConetxt =FXMLLoader.load(this.getClass().getResource("/lk/ijse/hostel_Management/view/KeyMoney-form.fxml"));

                case "imgBookingDetaiks" :
                    MainPageConetxt =FXMLLoader.load(this.getClass().getResource("/lk/ijse/hostel_Management/view/Reservation-detailForm.fxml"));



            }

            if(MainPageConetxt !=null){
                Scene subScene =new Scene(MainPageConetxt);
                Stage primaryStage= (Stage) this.MainPageConetxt.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt =new TranslateTransition(Duration.millis(350),subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
            }


        }




    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {


        if(mouseEvent.getSource()instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();


            switch (icon.getId()){
                case "imgBookingRoom":
                    lblMenu.setText("Add new Customer");
                    lblDescription.setText("Click to check reports");
                    break;



                case "imgStudents":
                    lblMenu.setText("Place Order");
                    lblDescription.setText("Click to Place A Order");
                    break;


                case "imgKeyMoney":
                    lblMenu.setText("Manager Orders");
                    lblDescription.setText("Click to Manager Orders Form Customers");
                    break;


                case "imgBookingDetaiks":
                    lblMenu.setText("Manager= Orders");
                    lblDescription.setText("Click to Manager Orders Form Customers");
                    break;



            }

            ScaleTransition scaleTransition=new ScaleTransition(Duration.millis(200),icon);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();

            DropShadow glow =new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);



        }



    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition  scaleT=new ScaleTransition(Duration.millis(200),icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();


            icon.setEffect(null);
            lblMenu.setText("Welcome Cashier");
            lblDescription.setText("Please select one of above main operations to proceed");


        }



    }
}
