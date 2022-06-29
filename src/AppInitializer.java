import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

public static void main(String args){
    launch(args);
}


    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostel_Management/view/loginPage.fxml")));
        primaryStage.setScene(scene);
        primaryStage.show();


    }



}
