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

public class Controller implements Initializable {

    public Button insertion;
    public Button update;
    public Button Delete;
    public Button Search;
    public Button back;
    public Button RecordList;
    public Button snackr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void Insert(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Insertion.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Insert The Movies Details");
        st.show();
        insertion.getScene().getWindow().hide();

    }

    public void Updation(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Updation.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Update The Movies Details");
        st.show();
        update.getScene().getWindow().hide();

    }

    public void Deletion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Deletion.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Delete The Movies Details");
        st.show();
        Delete.getScene().getWindow().hide();
    }

    public void Searching(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("ReadMovies.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Search The Movies Details");
        st.show();
        Search.getScene().getWindow().hide();
    }

    public void Goback(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Welcome To Fireplex");
        st.show();
        back.getScene().getWindow().hide();
    }

    public void bookcheck(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("TicketRecords.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        javafx.scene.Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("All Booked Tickets Records");
        st.show();
        back.getScene().getWindow().hide();
    }

}
