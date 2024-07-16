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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Deletion implements Initializable {


    public DatePicker Dates;
    public TextField Timings;
    public TextField MovieT;
    public Button Delete;
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
    public TextField Seat_Classes;

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
        SeatClass.setCellValueFactory(new PropertyValueFactory<>("SeatClass"));    }

    public void kill(ActionEvent actionEvent) throws SQLException {
        String sql ="DELETE FROM movies WHERE Movies='"+MovieT.getText()+"'";
        PreparedStatement statement = cn.prepareStatement(sql);

        int rowsDeleted = statement.executeUpdate();

        if (rowsDeleted > 0) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Successful Delete");
            a.show();
        }
        else if(rowsDeleted == 0){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.show();
        }
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
    public void check(MouseEvent mouseEvent) {
        ConstructorInsert CI = (ConstructorInsert) Records.getSelectionModel().getSelectedItem();
        MovieT.setText(CI.getMovies());
        Dates.setValue(LocalDate.parse(CI.getDate()));
        Timings.setText(CI.getTime());
        Screen_no.setText(CI.getScreen());
        no_seats.setText(CI.getSeats());
        Seat_Classes.setText(CI.getSeatClass());
    }
}
