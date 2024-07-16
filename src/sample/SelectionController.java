package sample;

import Database.Movies;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SelectionController implements Initializable {

    public Button Home;
    public Button About;
    public Button Contact;
    public Button back;
    public Button Book;
    public Button Display;
    public TableView<ConstructorInsert> Records;
    public TableColumn<ConstructorInsert,String> Movies;
    public TableColumn<ConstructorInsert,String> Date;
    public TableColumn<ConstructorInsert,String> Time;
    public TableColumn<ConstructorInsert,String> Seats;
    public TableColumn<ConstructorInsert,String> Screen;
    public TableColumn<ConstructorInsert,String> SeatClass;

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

    public void HomePage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Welcome To FirePlex");
        st.show();
        Home.getScene().getWindow().hide();
    }

    public void AboutUS(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("AboutUS.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("About Us");
        st.show();
        About.getScene().getWindow().hide();
    }

    public void Contact(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("ContactUS.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Contact Us");
        st.show();
        Contact.getScene().getWindow().hide();
    }

    public void Booking(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("BookingPage.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,483,570);
        st.setScene(sc);
        st.setTitle("Book Your Tickets Now");
        st.show();
        Book.getScene().getWindow().hide();
    }

    public void ShowAll(ActionEvent actionEvent) throws SQLException{
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

    public void Goback(ActionEvent actionEvent) throws IOException{
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Welcome To FirePlex");
        st.show();
        back.getScene().getWindow().hide();
    }
}
