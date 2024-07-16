package sample;

import Database.TicketBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BookingPage implements Initializable {
    public TextField email;
    public TextField MovieT;
    public TextField Screen;
    public TextField No_Tickets;
    public TextField name;
    public TextField SeatClass;
    public Button Book;
    public Button back;

    TicketBook tb = new TicketBook();
    Connection cn = tb.getConnection();
    ObservableList<ConstructorInsert> ob= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void save(ActionEvent actionEvent) throws SQLException {
        TicketBook tb = new TicketBook();
        cn = tb.getConnection();
        String query = "INSERT INTO ticketbook(FullName,Email,Movies,Screen,TicketsBooked,SeatClass) VALUES ('"+name.getText()+"','"+email.getText()+"','"+MovieT.getText()+"','"+Screen.getText()+"','"+No_Tickets.getText()+"','"+SeatClass.getText()+"')";
        Statement state = cn.createStatement();
        state.executeUpdate(query);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Success");
        a.setContentText("Your Tickets Have Been Booked And Reserved");
        a.show();
    }

    public void Goback(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("Selection.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,1080,570);
            st.setScene(sc);
            st.setTitle("Welcome To Fireplex ");
            st.show();
            back.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

