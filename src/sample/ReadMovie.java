package sample;

import Database.Movies;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ReadMovie implements Initializable {

    public DatePicker Dates;
    public TextField Timings;
    public TextField MovieT;
    public TextField no_seats;
    public Button Display;
    public TableView<ConstructorInsert> Records;
    public TableColumn<ConstructorInsert,String> Movies;
    public TableColumn<ConstructorInsert,String> Date;
    public TableColumn<ConstructorInsert,String> Time;
    public TableColumn<ConstructorInsert,String> Seats;
    public TableColumn<ConstructorInsert,String> Screen;
    public TableColumn<ConstructorInsert,String> SeatClass;
    public Button back;
    public TextField Screen_no;
    public TextField SeatClasses;

    Movies m = new Movies();
    Connection cn = m.getConnection();
    ObservableList<ConstructorInsert> ob= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    Movies.setCellValueFactory(new PropertyValueFactory<>("Movies"));
    Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
    Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
    Seats.setCellValueFactory(new PropertyValueFactory<>("Seats"));
    Screen.setCellValueFactory(new PropertyValueFactory<>("Movies"));
    SeatClass.setCellValueFactory(new PropertyValueFactory<>("SeatClass"));

    }

    public void Read(ActionEvent actionEvent) throws SQLException {
        Movies MV = new Movies();
        cn=MV.getConnection();
        String s ="SELECT * FROM movies";

        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(s);
            while (rs.next())
            {
                ob.add(new ConstructorInsert(rs.getString("Movies"),rs.getString("Date"),rs.getString("Time"),rs.getString("Seats"),rs.getString("Screen"),rs.getString("SeatClass")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Records.setItems(ob);

    }

    public void Goback(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,1080,570);
            st.setScene(sc);
            st.setTitle("Admin Window");
            st.show();
            back.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

