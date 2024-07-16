package sample;

import Database.TicketBook;
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

public class TicketRecords implements Initializable {
    public TableView<TicketRecordsConstructor> Record;
    public TableColumn<TicketRecordsConstructor,String> FullName;
    public TableColumn<TicketRecordsConstructor,String>  Email;
    public TableColumn<TicketRecordsConstructor,String>  Movies;
    public TableColumn<TicketRecordsConstructor,String>  Screen;
    public TableColumn<TicketRecordsConstructor,String>  Ticketsbooked;
    public TableColumn<TicketRecordsConstructor,String>  SeatClass;
    public Button back;
    public TextField email;
    public TextField MovieT;
    public TextField Screens;
    public TextField No_Tickets;
    public TextField name;
    public TextField SeatClasses;
    public Button Search;
    public Button Delete;
    public Button Update;

    TicketBook TB = new TicketBook();
    Connection cn = TB.getConnection();
    ObservableList<TicketRecordsConstructor> ob= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Movies.setCellValueFactory(new PropertyValueFactory<>("Movies"));
        Screen.setCellValueFactory(new PropertyValueFactory<>("Screen"));
        Ticketsbooked.setCellValueFactory(new PropertyValueFactory<>("Ticketsbooked"));
        SeatClass.setCellValueFactory(new PropertyValueFactory<>("SeatClass"));
    }

    public void select(MouseEvent mouseEvent) {
       TicketRecordsConstructor TRC = (TicketRecordsConstructor) Record.getSelectionModel().getSelectedItem();
        name.setText(TRC.getFullName());
        email.setText(TRC.getEmail());
        MovieT.setText(TRC.getMovies());
        Screens.setText(TRC.getScreen());
        No_Tickets.setText(TRC.getTicketsbooked());
        SeatClasses.setText(TRC.getSeatClass());
    }

    public void Goback(ActionEvent actionEvent) {
        try{
            FXMLLoader fm=new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = fm.load();
            Stage st=new Stage();
            Scene sc=new Scene(root,1080,570);
            st.setScene(sc);
            st.setTitle("Admin Window ");
            st.show();
            back.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Display(ActionEvent actionEvent) {
        cn=TB.getConnection();
        String s ="SELECT * FROM ticketbook";

        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(s);
            while (rs.next())
            {
                ob.add(new TicketRecordsConstructor(rs.getString("FullName"),rs.getString("Email"),rs.getString("Movies"),rs.getString("Screen"),rs.getString("Ticketsbooked"),rs.getString("SeatClass")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Record.setItems(ob);

    }

    public void Deletion(ActionEvent actionEvent) throws SQLException {
        String sql ="DELETE FROM ticketbook WHERE Email='"+email.getText()+"'";
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

    public void Updation(ActionEvent actionEvent) throws SQLException {
        String upd = "UPDATE ticketbook SET Ticketsbooked='"+No_Tickets.getText()+"' WHERE FullName='"+name.getText()+"'";
        PreparedStatement pst = cn.prepareStatement(upd);
        int Affected = pst.executeUpdate();
        if(Affected > 0)
        {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Successful Update");
            a.show();
        }
    }
}
