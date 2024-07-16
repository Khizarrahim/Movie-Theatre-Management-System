package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable {


    public TextField username;
    public PasswordField password;
    public Button SignIn;
    public Button Home;
    public Button About;
    public Button Contact;
    public Button back;

    public void check_login(ActionEvent actionEvent) {
        String us=username.getText();
        String ps=password.getText();

        if(us.equals("Khizer31") && ps.equals("winner")){
            try{
                FXMLLoader fm=new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root = fm.load();
                Stage st=new Stage();
                Scene sc=new Scene(root,1080,580);
                st.setScene(sc);
                st.setTitle("Welcome Admin ");
                st.show();

                SignIn.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error ");
            a.setContentText("Invalid Username or Password ");
            a.show();
        }
    }

    public void HomePage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Welcome Page");
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
        FXMLLoader fm=new FXMLLoader(getClass().getResource("ContactUs.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Contact Us");
        st.show();
        Contact.getScene().getWindow().hide();
    }

    public void GoBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader fm=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root = fm.load();
        Stage st=new Stage();
        Scene sc=new Scene(root,1080,570);
        st.setScene(sc);
        st.setTitle("Welcome To Fireplex");
        st.show();
        back.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
