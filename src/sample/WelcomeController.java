package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController  implements Initializable {


    public Button BuyTickets;
    public Button Show;
    public Button Admin;


    public void Login(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,1080,570);
            st.setScene(sc);
            st.setTitle("Admin Window");
            st.show();
            Admin.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void Buy(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("BookingPage.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,453,570);
            st.setScene(sc);
            st.setTitle("Buy Your Tickets");
            st.show();
            BuyTickets.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Display(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("Selection.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,1080,570);
            st.setScene(sc);
            st.setTitle("Welcome To Fireplex");
            st.show();
            Show.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
